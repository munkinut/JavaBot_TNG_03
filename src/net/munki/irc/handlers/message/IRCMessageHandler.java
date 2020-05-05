/*
 * MessageHandler.java
 *
 * Handles non-numeric messages from the server
 *
 * Created on 18 July 2002, 07:20
 */

package net.munki.irc.handlers.message;

import net.munki.irc.bot.BotEnv;
import net.munki.irc.event.IRCCommandEvent;
import net.munki.irc.event.IRCMessageEvent;
import net.munki.irc.event.IRCScriptEvent;
import net.munki.irc.message.CommandMessageInterface;
import net.munki.irc.message.PingMessage;
import net.munki.irc.message.PrivmsgMessage;
import net.munki.irc.protocol.rfc2812.MessageHandlerException;
import net.munki.irc.protocol.rfc2812.MessageNames;

import java.util.ArrayList;
import java.util.logging.Logger;

/** Provides handler implementations for several common IRC messages. */
public class IRCMessageHandler extends IRCMessageAdapter {
    
    /** The bot environment. */    
    private BotEnv env;
    /** The logger to which all log data should be sent for this class. */    
    private final Logger logger;
    
    /** Creates a new IRCMessage handler object. */    
    public IRCMessageHandler() {
        super();
        logger = Logger.getLogger(this.getClass().getName());
    }
    
    /** Dispatches message to any available handlers.
     * @param evt The message event.
     * @throws MessageHandlerException Thrown if a handler fails to handle the dispatched message.
     */    
    public void dispatch(IRCMessageEvent evt) throws MessageHandlerException {
        if ((evt.getSource() instanceof BotEnv) && (evt.getActionCommand() instanceof CommandMessageInterface)) {
            logger.info("Message Event valid; dispatching ...");
            env = (BotEnv)evt.getSource();
            CommandMessageInterface message = (CommandMessageInterface)evt.getActionCommand();
            this.handleMessage(message);
            env = null;
        }
        else logger.warning("Invalid Message Event ...");
    }
    
    /** Parses incoming messages and responds accordinging.
     * @param message The message.
     * @throws MessageHandlerException Thrown if a handler fails to handle the dispatched message.
     */    
    private void handleMessage(CommandMessageInterface message) throws MessageHandlerException {
        
        String type = message.getMessageType();
        
        if (type.equals(MessageNames.PING)) {
            logger.info("Message Handler received a PING message ...");
            PingMessage pm = (PingMessage)message;
            this.PONG(pm.getParameters());
        }
        
        else if (type.equals(MessageNames.PRIVMSG)) {
            logger.info("Message Handler received a PRIVMSG message ...");
            PrivmsgMessage pm = (PrivmsgMessage)message;

            // if it is a script command (starts with '!') pass it to a script handler
            if (pm.getMessage().startsWith("!")) {
                logger.info("PRIVMSG is a script command ...");
                IRCScriptEvent ice = new IRCScriptEvent(env, pm);
                env.fireIRCScriptEvent(ice);
            }
        }
                
        else logger.info("Message not handled by this message handler ...");
    }

    @Override
    public void JOIN(ArrayList<String> channels, ArrayList<String> keys) {

    }

    /** 3.7.3 Pong message - implementation
     * @param server_1 The server to which to respond.
     * @throws MessageHandlerException Thrown if a handler fails to handle the dispatched message.
     */
    public void PONG(String server_1) throws MessageHandlerException {
        if (env != null) {
            logger.info("Handling Ping, dispatching PONG command event ...");
            IRCCommandEvent evt = new IRCCommandEvent(env, MessageNames.PONG);
            evt.addParameter(server_1);
            env.fireIRCCommandEvent(evt);
        }
        else logger.warning("Bot environment has not been initialised ...");
    }

    @Override
    public void JOIN(ArrayList<String> channels) {

    }

}
