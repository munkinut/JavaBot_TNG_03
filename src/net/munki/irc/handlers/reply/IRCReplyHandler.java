/*
 * IRCReplyHandler.java
 *
 * Handles numeric messages from the server
 *
 * Created on 18 July 2002, 07:20
 */

package net.munki.irc.handlers.reply;

import net.munki.irc.bot.BotEnv;
import net.munki.irc.channel.Channel;
import net.munki.irc.event.IRCCommandEvent;
import net.munki.irc.event.IRCReplyEvent;
import net.munki.irc.message.NicknameInUseMessage;
import net.munki.irc.message.ReplyMessageInterface;
import net.munki.irc.message.WelcomeMessage;
import net.munki.irc.protocol.rfc2812.MessageHandlerException;
import net.munki.irc.protocol.rfc2812.MessageNames;
import net.munki.irc.protocol.rfc2812.ReplyHandlerException;
import net.munki.irc.protocol.rfc2812.ReplyNames;
import net.munki.util.string.StringTool;

import java.util.logging.Logger;

/** Handles numerically coded reply messages. */
public class IRCReplyHandler extends IRCReplyAdapter {
    
    /** The bot environment. */    
    private BotEnv env;
    /** The logger to which all log data for this class is sent. */    
    private Logger logger;
    
    /** Creates a new IRCReplyHandler. */    
    public IRCReplyHandler() {
        super();
        logger = Logger.getLogger(this.getClass().getName());
    }
    
    /** Dispatches reply events to any available listeners.
     * @param evt The event.
     * @throws ReplyHandlerException Thrown if a handler fails to handle the dispatched message.
     */    
    public void dispatch(IRCReplyEvent evt) throws ReplyHandlerException {
        if ((evt.getSource() instanceof BotEnv) && (evt.getActionCommand() instanceof ReplyMessageInterface)) {
            logger.fine("Reply Event valid; dispatching ...");
            env = (BotEnv)evt.getSource();
            ReplyMessageInterface message = (ReplyMessageInterface)evt.getActionCommand();
            this.handleMessage(message);
            env = null;
        }
        else logger.warning("Invalid Reply Event ...");
    }
    
    /** Handles incoming reply messages.
     * @param message The message to handle.
     * @throws ReplyHandlerException Thrown if a dispatcher fails to handle the message.
     */    
    private void handleMessage(ReplyMessageInterface message) throws ReplyHandlerException {
        
        String type = message.getMessageType();
        
        if (type.equals(ReplyNames.ERR_NICKNAMEINUSE)) {
            logger.fine("Reply Handler received a ERR_NICKNAMEINUSE message ...");
            NicknameInUseMessage nium = (NicknameInUseMessage)message;
            if (nium != null) this.ERR_NICKNAMEINUSE(nium.getMessage());
        }
        
        else if (type.equals(ReplyNames.RPL_WELCOME)) {
            logger.fine("Reply Handler received a RPL_WELCOME message ...");
            WelcomeMessage wm = (WelcomeMessage)message;
            if (wm != null) this.RPL_WELCOME(wm.getMessage());
        }
        
        else logger.fine("Message not handled by this reply handler ...");
    }
    
    /** Implementation of ERR_NICKNAMEINUSE handler method.
     * Asks the environment for another nickname and dispatches
     * a NICK command accordingly.
     * @param reply The reply.
     * @throws ReplyHandlerException Thrown if any handler fails to handle the message.
     */    
    public void ERR_NICKNAMEINUSE(String reply) throws ReplyHandlerException {
        if (env != null) {
            logger.fine("Handling ERR_NICKNAMEINUSE ...");
            String alt = env.nextNick();
            try {
                this.nick(alt);
            }
            catch (MessageHandlerException mhe) {
                logger.warning("Failed to handle ERR_NICKNAMEINUSE ...");
                throw new ReplyHandlerException(mhe);
            }
        }
    }
    
    /** Implementation of the handler for RPL_WELCOME.
     * The server can now accept commands, so a JOIN command
     * is dispatched.
     * @param reply The reply.
     * @throws ReplyHandlerException Thrown if any handler fails to handle the message.
     */    
    public void RPL_WELCOME(String reply) throws ReplyHandlerException {
        if (env != null) {
            logger.fine("Handling RPL_WELCOME ...");
            try {
                this.join(this.getChannelsToJoin());
            }
            catch (MessageHandlerException mhe) {
                logger.warning("Failed to handle RPL_WELCOME ...");
                throw new ReplyHandlerException(mhe);
            }
        }
    }
    
    /** Sends a NICK command.
     * @param nick The nickname to send.
     * @throws MessageHandlerException Thrown if a handler fails to handle the dispatched message.
     */    
    private void nick(String nick) throws MessageHandlerException {
        logger.fine("Firing NICK command event ...");
        IRCCommandEvent evt = new IRCCommandEvent(env, MessageNames.NICK);
        evt.addParameter(nick);
        env.fireIRCCommandEvent(evt);
    }
    
    /** Sends a JOIN command.
     * @param channels The channels to join.
     * @throws MessageHandlerException Thrown if a handler fails to handle the dispatched message.
     */    
    private void join(String[] channels) throws MessageHandlerException {
        logger.fine("Firing JOIN command event ...");
        IRCCommandEvent evt = new IRCCommandEvent(env, MessageNames.JOIN);
        evt.addParameter(channels);
        env.fireIRCCommandEvent(evt);
    }
    
    /** Provides a list of channels the bot is to join.
     * @return A list of channels for the bot to join.
     */    
    private String[] getChannelsToJoin() {
        Object[] chans = (env.getChannels()).toArray();
        String[] chanNames = new String[chans.length];
        for (int i = 0; i < chans.length; i++) {
            if (chans[i] instanceof Channel) {
                String chanName = ((Channel)chans[i]).getName();
                chanNames[i] = chanName;
                logger.finer(StringTool.cat(new String[] {"Added ", chanName, " to list of channels to join ..."}));
            }
        }
        return chanNames;
    }
    
}
