/*
 * IRCScriptHandler.java
 *
 * Created on 27 July 2002, 10:14
 */

package net.munki.irc.handlers.script.beanshell;

import bsh.EvalError;
import net.munki.irc.bot.BotEnv;
import net.munki.irc.event.IRCScriptEvent;
import net.munki.irc.handlers.script.IRCScriptResource;
import net.munki.irc.message.PrivmsgMessage;
import net.munki.irc.util.ScriptTool;
import net.munki.util.string.StringTool;

import java.util.logging.Logger;

/** Handles script messages. */
public class BeanshellScriptHandler extends BeanshellScriptAdapter {

    /** The logger to which all log data for this class should be sent. */
    private final Logger logger;
    
    /** A script handler. */    
    public BeanshellScriptHandler() {
        super();
        logger = Logger.getLogger(this.getClass().getName());
    }

    /** Dispatches script events.
     * @param evt The event to dispatch.
     */    
    public void dispatch(IRCScriptEvent evt) {
        
        // make sure the source is valid and the trigger is part of a Privmsg
        if ((evt.getSource() instanceof BotEnv) && (evt.getActionCommand() instanceof PrivmsgMessage)) {
            logger.fine("Script Event valid; dispatching ...");
            /* The bot environment. */
            BotEnv env = (BotEnv) evt.getSource();
            PrivmsgMessage pmm = (PrivmsgMessage)evt.getActionCommand();
            String nick = pmm.getNick();            // their nick
            String modifier = pmm.getModifier();    // any modifier like "~" or "-"
            String user = pmm.getUser();            // their user
            String host = pmm.getHost();            // their host
            String addressee = pmm.getAddressee();  // my nick or the channel i hope
            String message = pmm.getMessage();      // the message
            
            // creating a mask lets us verify the id of the caller
            String mask = StringTool.cat(new String[] {nick,"!",modifier,user,"@",host});
            
            String command = null;
            String[] arguments = null;
            
            // parse the message into a scriptname and some parameters
            // message length must be > 1 (inc trigger character and command)
            if ((message != null) && (message.length() > 1)) {
                logger.finer("Valid script message ...");
                // message command must have at least a trigger
                // and a command, therefore no spaces within 2 characters
                if (message.indexOf(" ") > 1) {
                    logger.finer("Script message has arguments ...");
                    // we have a command plus arguments
                    // strip the trigger character
                    // command is the first argument up to a <space>
                    command = message.substring(1, message.indexOf(" "));
                    String args = message.substring(message.indexOf(" ")+1);
                    arguments = StringTool.uncat(args);
                }
                else {
                    logger.finer("Script message has no arguments ...");
                    // we just have a command, strip the trigger and 
                    // make arguments empty
                    command = message.substring(1);
                    arguments = new String[0];
                }
            }
            else logger.warning("Invalid script message ...");
            
            // convert our command to a script name
            // create a script resource and pass it to the interpreter
            // interpret the script
            if (command != null) {
                logger.fine("Valid script command; dispatching to interpreter ...");
                String script = ScriptTool.pathToBeanshellScript(command);
                IRCScriptResource isr = new IRCScriptResource(env, nick, mask, addressee, arguments);
                try {
                    interpreter.set("scriptResource", isr);
                    interpreter.source(script);
                }
                catch (EvalError e) {
                    String report = StringTool.cat(new String[] {
                        "Error evaluating ", 
                        script, 
                        ". Error message was : ",
                        e.getMessage(),
                        " ..."
                    });
                    logger.warning(report);
                }
                catch (java.io.FileNotFoundException fnfe) {
                    String report = StringTool.cat(new String[] {
                        "Script file not found ",
                        script,
                        ". Error message was : ",
                        fnfe.getMessage(),
                        " ..."
                    });
                    logger.info(report);
                }
                catch (java.io.IOException ioe) {
                    String report = StringTool.cat(new String[] {
                        "Error reading ", 
                        script,
                        ". Error message was : ",
                        ioe.getMessage(),
                        " ..."
                    });
                    logger.info(report);
                }
            }
            else logger.warning("Script command was null ...");
        }
        else logger.warning("Invalid script event ...");
    }
}
