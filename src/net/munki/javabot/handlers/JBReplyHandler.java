package net.munki.javabot.handlers;/*
 * JBReplyHandler.java
 *
 * Handles numeric messages from the server
 *
 * Created on 18 July 2002, 07:20
 */

import net.munki.irc.bot.BotEnv;
import net.munki.irc.channel.Channel;
import net.munki.irc.channel.ChannelUser;
import net.munki.irc.event.IRCReplyEvent;
import net.munki.irc.handlers.reply.IRCReplyAdapter;
import net.munki.irc.message.ReplyMessageInterface;
import net.munki.irc.message.WhoReplyMessage;
import net.munki.irc.protocol.rfc2812.ReplyHandlerException;
import net.munki.irc.protocol.rfc2812.ReplyNames;
import net.munki.util.string.StringTool;

import java.util.ArrayList;
import java.util.logging.Logger;

/** Custom Numeric Reply Handler. */
public class JBReplyHandler extends IRCReplyAdapter {
    
    private BotEnv env;
    private final Logger logger;
    
    /** Creates a new reply handler. */    
    public JBReplyHandler() {
        super();
        logger = Logger.getLogger(this.getClass().getName());
    }
    
    /** Dispatches commands on the basis of replies received.
     * @param evt The event to dispatch.
     * @throws ReplyHandlerException Thrown when a handler fails to handle our messages.
     */    
    public void dispatch(IRCReplyEvent evt) throws ReplyHandlerException {
        
        if ((evt.getSource() instanceof BotEnv) && (evt.getActionCommand() instanceof ReplyMessageInterface)) {
            logger.info("Reply event valid; dispatching ...");
            env = (BotEnv)evt.getSource();
            ReplyMessageInterface message = (ReplyMessageInterface)evt.getActionCommand();
            this.handleMessage(message);
            env = null;
        }
        else logger.warning("Invalid reply event ...");
    }
    
    private void handleMessage(ReplyMessageInterface message) {
        
        String type = message.getMessageType();
        if (type.equals(ReplyNames.RPL_WHOREPLY)) {
            logger.info("Handling who reply message ...");
            WhoReplyMessage wrm = (WhoReplyMessage)message;
            String channelName = wrm.getChannel();
            String userName = wrm.getUser();
            String host = wrm.getHost();
            String server = wrm.getServer();
            String nick = wrm.getNick();
            String HG = wrm.getHG();
            String asterisk = wrm.getAsterisk();
            String userStatus = wrm.getUserStatus();
            String hopCount = wrm.getHopCount();
            String realName = wrm.getRealName();
            logger.info(StringTool.cat(new String[] {
                "channelName = ", channelName, "\n",
                "userName = ", userName, "\n",
                "host = ", host, "\n",
                "server = ", server, "\n",
                "nick = ", nick, "\n",
                "HG = ", HG, "\n",
                "asterisk = ", asterisk, "\n",
                "userStatus = ", userStatus, "\n",
                "hopCount = ", hopCount, "\n",
                "realName = ", realName, "\n"}));
            ArrayList<Channel> channels = env.getChannels();
            for (int i = 0; i < channels.size(); i++) {
                Channel channel = channels.get(i);
                if ((channel.getName()).equals(channelName)) {
                    logger.info("This is one of our channels ...");
                    ArrayList<ChannelUser> channelUsers = channel.getUsers();
                    logger.info(StringTool.cat(new String[] {"Adding ", nick, " ..."}));
                    ChannelUser channelUser = new ChannelUser(nick, "", userName, host);
                    if (userStatus.equals("@")) channelUser.op();
                    else if (userStatus.equals("+")) channelUser.voice();
                    channelUsers.add(channelUser);
                }
            }
        }
        
        else logger.info("Message not handled by this reply handler ...");
        
    }
    
}
