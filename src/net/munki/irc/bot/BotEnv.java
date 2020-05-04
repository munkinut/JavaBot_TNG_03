/*
 * BotEnv.java
 *
 * Created on 22 July 2002, 23:51
 */

package net.munki.irc.bot;

import net.munki.irc.connection.Connection;
import net.munki.irc.event.*;
import net.munki.irc.handlers.command.IRCCommandInterface;
import net.munki.irc.protocol.rfc2812.MessageHandlerException;
import net.munki.irc.protocol.rfc2812.ReplyHandlerException;
import net.munki.util.string.StringTool;

import java.io.PrintStream;
import java.util.List;
import java.util.logging.Logger;

/** The public environment for the bot.
 * This provides an API for message, command 
 * and script handlers.
 */
public class BotEnv {
    
    /** The list of nicks the bot can use. */    
    private final String[] nicks;
    /** The index of the nick in use. */    
    private int nickIndex;
    /** The list of channels the bot can join. */    
    private final List channels;
    /** The list of message listeners. */    
    private final List messageListeners;
    /** The list of reply listeners. */    
    private final List replyListeners;
    /** The list of command listeners. */    
    private final List commandListeners;
    /** The list of script listeners. */    
    private final List scriptListeners;
    /** The output stream to which output should be sent. */    
    private PrintStream output;
    /** The logger to which log message from this class are sent. */    
    private Logger logger;

    /** Creates a new bot environment.
     * @param replyListeners The list of registered reply listeners.
     * @param scriptListeners The list of registered script listeners.
     * @param nicks An array of nicknames
     * @param nickIndex The index of the chosen nickname
     * @param channels An array of channels to join
     * @param messageListeners A list of message handlers
     * @param commandListeners A list of command handlers
     * @param output The output stream
     */
    public BotEnv(String[] nicks, int nickIndex, List channels, List messageListeners, List commandListeners, List replyListeners, List scriptListeners, PrintStream output) {
        this.nicks = nicks;
        this.nickIndex = nickIndex;
        this.channels = channels;
        this.messageListeners = messageListeners;
        this.commandListeners = commandListeners;
        this.replyListeners = replyListeners;
        this.scriptListeners = scriptListeners;
        this.output = output;
        initLogger();
    }
    
    /** Initialises the logger. */    
    private void initLogger() {
        logger = Logger.getLogger(this.getClass().getName());
    }
    
    /** Sets the output stream.
     * @param output The output stream to use.
     */    
    protected void setOutput(PrintStream output) {
        this.output = output;
    }
    
    /** Passes the active connection to registered command handlers.
     * @param connection The active connection.
     */    
    protected void activateCommandHandlers(Connection connection) {
        Object[] handlers = commandListeners.toArray();
        for (int i = 0; i < handlers.length; i++) {
            if (handlers[i] instanceof IRCCommandInterface) {
                IRCCommandInterface ica = (IRCCommandInterface)handlers[i];
                logger.fine(StringTool.cat(new String[] {"Initialising command handler ", Integer.valueOf(i).toString(), " ..."}));
                ica.setConnection(connection);
            }
        }
    }
    
    /** Registers a message handler.
     * @param messageHandler The message handler to register.
     */    
    protected void registerMessageHandler(IRCMessageListener messageHandler) {
        logger.fine("Registering message handler ...");
        messageListeners.add(messageHandler);
    }
    
    /** Unregisters a message handler.
     * @param messageHandler The message handler to unregister.
     */    
    protected void unregisterMessageHandler(IRCMessageListener messageHandler) {
        logger.fine("Unregistering message handler ...");
        messageListeners.remove(messageHandler);
    }
    
    /** Registers a reply handler.
     * @param replyHandler The reply handler to register.
     */    
    protected void registerReplyHandler(IRCReplyListener replyHandler) {
        logger.fine("Registering reply handler ...");
        replyListeners.add(replyHandler);
    }
    
    /** Unregisters a reply handler.
     * @param replyHandler The reply handler to unregister.
     */    
    protected void unregisterReplyHandler(IRCReplyListener replyHandler) {
        logger.fine("Unregistering reply handler ...");
        replyListeners.remove(replyHandler);
    }
    
    /** Registers a command handler.
     * @param commandHandler The command handler to register.
     */    
    protected void registerCommandHandler(IRCCommandListener commandHandler) {
        logger.fine("Registering command handler ...");
        commandListeners.add(commandHandler);
    }
    
    /** Unregisters a command handler.
     * @param commandHandler The command handler to unregister.
     */    
    protected void unregisterCommandHandler(IRCCommandListener commandHandler) {
        logger.fine("Unregistering command handler ...");
        commandListeners.remove(commandHandler);
    }
    
    /** Registers a script handler.
     * @param scriptHandler Script handler to register
     */    
    protected void registerScriptHandler(IRCScriptListener scriptHandler) {
        logger.fine("Registering script handler ...");
        scriptListeners.add(scriptHandler);
    }
    
    /** Unregister a script handler.
     * @param scriptHandler Script handler to unregister
     */    
    protected void unregisterScriptHandler(IRCScriptListener scriptHandler) {
        logger.fine("Unregistering script handler ...");
        scriptListeners.remove(scriptHandler);
    }
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    /** Returns the bots current nickname.
//     * @return The bots current nickname
//     */
//    public String getNick() {
//        return nicks[nickIndex];
//    }
// --Commented out by Inspection STOP (04/05/2020 21:37)

    /** Returns the bots next available nickname.
     * @return The next available nickname
     */    
    public String nextNick() {
        nickIndex++;
        String nick;
        if (nickIndex < nicks.length) {
            logger.fine("Choosing next available nick ...");
            nick = nicks[nickIndex];
        }
        else {
            logger.fine("No more nicks to choose from.  Cycling ...");
            nickIndex = -1;
            nick = this.nextNick();
        }
        return nick;
    }            
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    /** Returns the list of channels.
//     * @return The list of channels
//     */
//    public List getChannels() {
//        return channels;
//    }
//
//    /** Returns the print stream for output.
// --Commented out by Inspection STOP (04/05/2020 21:37)
     * @return The printstream
     */    
    public PrintStream getPrintStream() {
        return output;
    }

    /** Fires a message event at any registered message listeners.  Message listeners are registered through the bot core.
     * @param evt A message event
     * @throws MessageHandlerException Thrown if a MessageHandler refuses to handle our message.
     */    
    public void fireIRCMessageEvent(IRCMessageEvent evt) throws MessageHandlerException {
        Object[] handlers = messageListeners.toArray();
        for (int i = 0; i < handlers.length; i++) {
            if (handlers[i] instanceof IRCMessageListener) {
                IRCMessageListener mh = (IRCMessageListener)handlers[i];
                // String name = mh.getClass().getName();
                logger.fine(StringTool.cat(new String[] {"Message handler ", Integer.valueOf(i).toString(), " handling ..."}));
                mh.dispatch(evt);
            }
        }
    }
    
    /** Fires a command event at any registered command listeners.  Command listeners are registered through the bot core.
     * @param evt A command event
     * @throws MessageHandlerException Thrown if an error occurs while handling the event
     */    
    public void fireIRCCommandEvent(IRCCommandEvent evt) throws MessageHandlerException {
        Object[] handlers = commandListeners.toArray();
        for (int i = 0; i < handlers.length; i++) {
            if (handlers[i] instanceof IRCCommandListener) {
                IRCCommandListener ica = (IRCCommandListener)handlers[i];
                String name = ica.getClass().getName();
                logger.fine(StringTool.cat(new String[] {"Command handler ", name, " handling ..."}));
                ica.dispatch(evt);
            }
        }
    }
    
    /** Fires a reply event at any registered reply listeners.  Reply listeners are registered through the bot core.
     * @param evt A reply event
     * @throws ReplyHandlerException Thrown if an error occurs while handling the event
     */    
    public void fireIRCReplyEvent(IRCReplyEvent evt) throws ReplyHandlerException {
        Object[] handlers = replyListeners.toArray();
        for (int i = 0; i < handlers.length; i++) {
            if (handlers[i] instanceof IRCReplyListener) {
                IRCReplyListener ira = (IRCReplyListener)handlers[i];
                String name = ira.getClass().getName();
                logger.fine(StringTool.cat(new String[] {"Reply handler ", name, " handling ..."}));
                ira.dispatch(evt);
            }
        }
    }
    
    /** Fires a script event at any registered script listeners.  Script listeners are registered through the bot core.
     * @param evt A script event
     */    
    public void fireIRCScriptEvent(IRCScriptEvent evt) {
        Object[] handlers = scriptListeners.toArray();
        for (int i = 0; i < handlers.length; i++) {
            if (handlers[i] instanceof IRCScriptListener) {
                IRCScriptListener ira = (IRCScriptListener)handlers[i];
                String name = ira.getClass().getName();
                logger.fine(StringTool.cat(new String[] {"Script handler ", name, " handling ..."}));
                ira.dispatch(evt);
            }
        }
    }
    
    /** Outputs a message to the configured output stream.
     * @param msg Message to report
     */    
    public void report(String msg) {
        output.println(msg);
    }
    
}
