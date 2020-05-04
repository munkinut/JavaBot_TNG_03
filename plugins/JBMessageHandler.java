/*
 * JBMessageHandler.java
 *
 * Handles non-numeric messages from the server
 *
 * Messages handled by the default message handler
 *
 * MessageNames.PING
 * MessageNames.PRIVMSG
 *
 * Messages handled by this message handler
 *
 * MessageNames.JOIN
 * MessageNames.PART
 * MessageNames.QUIT
 * MessageNames.PRIVMSG
 *
 * We handle PRIVMSG here in order to trap 
 * administrative commands like op, deop, ban and 
 * such like.  Admin commands will start with the '.' prefix
 *
 * Created on 18 July 2002, 07:20
 */

import net.munki.irc.bot.BotEnv;
import net.munki.irc.channel.Channel;
import net.munki.irc.channel.ChannelUser;
import net.munki.irc.event.IRCCommandEvent;
import net.munki.irc.event.IRCMessageEvent;
import net.munki.irc.handlers.message.IRCMessageAdapter;
import net.munki.irc.message.*;
import net.munki.irc.protocol.rfc2812.MessageHandlerException;
import net.munki.irc.protocol.rfc2812.MessageNames;
import net.munki.javabot.management.BotUserManagerInterface;
import net.munki.javabot.management.DefaultBotUserManager;
import net.munki.util.string.StringTool;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

/** A custom message handler. */
public class JBMessageHandler extends IRCMessageAdapter {
    
    private BotEnv env;
    private Logger logger;
    
    /** Creates a new JBMessageHandler. */    
    public JBMessageHandler() {
        super();
        logger = Logger.getLogger(this.getClass().getName());
    }
    
    /** Dispatches messages to any available listeners.
     * @param evt The event to dispatch.
     * @throws MessageHandlerException Thrown if any handler fails to handle our messages.
     */    
    public void dispatch(IRCMessageEvent evt) throws MessageHandlerException {

        if ((evt.getSource() instanceof BotEnv) && (evt.getActionCommand() instanceof CommandMessageInterface)) {
            logger.fine("Message event valid; dispatching ...");
            env = (BotEnv)evt.getSource();
            CommandMessageInterface message = (CommandMessageInterface)evt.getActionCommand();
            handleMessage(message);
            env = null;
        }
    }
    
    private void handleMessage(CommandMessageInterface message) throws MessageHandlerException {
        
        String type = message.getMessageType();
        
        // Place any extra message handlers here
        
        if (type.equals(MessageNames.JOIN)) {
            handleJoin(message);
        }
        
        else if (type.equals(MessageNames.PART)) {
            handlePart(message);
        }
        
        else if (type.equals(MessageNames.QUIT)) {
            handleQuit(message);
        }
        
        else if (type.equals(MessageNames.PRIVMSG)) {
            handlePrivmsg(message);
        }
                
        else logger.fine("Message not handled by this message handler ...");
    }
    
    private void handleJoin(CommandMessageInterface message) throws MessageHandlerException {
        logger.fine("Message was a JOIN ...");
        JoinMessage jm = (JoinMessage)message;

        // parse the message data
        String nickname = jm.getNick();
        String modifier = jm.getModifier();
        String user = jm.getUser();
        String host = jm.getHost();
        String channelName = jm.getChannel();
        logger.finer(StringTool.cat(new String[] {
            "Joiner was ",
            nickname,
            " on channel ",
            channelName,
            " ..."
        }));
        if (nickname.equals(env.getNick())) { // it's me, issue a /who cmd
            WHO(channelName, "");
        }
        ChannelUser joiner = new ChannelUser(nickname, modifier, user, host);
        addJoiner(joiner, channelName);
    }
    
    private void handlePart(CommandMessageInterface message) throws MessageHandlerException {
        logger.fine("Message was a PART ...");
        PartMessage jm = (PartMessage)message;

        // parse the message data
        String nickname = jm.getNick();
        String modifier = jm.getModifier();
        String user = jm.getUser();
        String host = jm.getHost();
        String channelName = jm.getChannel();
        logger.finer(StringTool.cat(new String[] {
            "Parter was ",
            nickname,
            " from channel ",
            channelName,
            " ..."
        }));
        ChannelUser parter = new ChannelUser(nickname, modifier, user, host);
        removeParter(parter, channelName);
    }
    
    private void handleQuit(CommandMessageInterface message) throws MessageHandlerException {
        logger.fine("Message was a QUIT ...");
        QuitMessage jm = (QuitMessage)message;

        // parse the message data
        String nickname = jm.getNick();
        String modifier = jm.getModifier();
        String user = jm.getUser();
        String host = jm.getHost();
        logger.finer(StringTool.cat(new String[] {
            "Quitter was ",
            nickname,
            " ..."
        }));
        ChannelUser quitter = new ChannelUser(nickname, modifier, user, host);
        removeQuitter(quitter);
    }
    
    private void handlePrivmsg(CommandMessageInterface message) throws MessageHandlerException {
        logger.fine("Message was a PRIVMSG ...");
        PrivmsgMessage pm = (PrivmsgMessage)message;
        String nick = pm.getNick();
        String modifier = pm.getModifier();
        String user = pm.getUser();
        String host = pm.getHost();
        String addressee = pm.getAddressee();
        String msg = pm.getMessage();
        ChannelUser channelUser = new ChannelUser(nick, modifier, user, host);
        logger.finer(StringTool.cat(new String[] {
            "Messager was ",
            nick,
            " to ",
            addressee,
            " ..."
        }));
        // if it is a handler command (starts with '.') handle it here
        if ((msg.length() > 1) && (msg.startsWith("."))) {

            // make sure the addressee was me and not a channel
            // work out what the command was
            // get its parameters
            // formulate a command event object and fire it
            if (addresseeIsMe(addressee)) {

                // its addressed to me so thats dandy
                // lets break down the message
                // get rid of the "."
                String commandAndParams = msg.substring(1);

                // get the command and a list of parameters
                String command;
                List params = new ArrayList();
                if (commandAndParams.indexOf(" ") > 0) {
                    // we have parameters
                    command = commandAndParams.substring(0,commandAndParams.indexOf(" "));
                    String paramString = commandAndParams.substring(commandAndParams.indexOf(" "));
                    StringTokenizer st = new StringTokenizer(paramString);
                    while (st.hasMoreTokens()) {
                        params.add(st.nextToken());
                    }
                }
                else {
                    // we just have a command
                    command = commandAndParams;
                }

                // examine the command and take some action
                if (command.equals("op")) {
                    handleOp(channelUser, params);
                }
                else if (command.equals("deop")) {
                    handleDeop(channelUser, params);
                }
                else if (command.equals("voice")) {
                    handleVoice(channelUser, params);
                }
                else if (command.equals("devoice")) {
                    handleDevoice(channelUser, params);
                }
            }
        }
    }
    
    private void handleOp(ChannelUser channelUser, List params) throws MessageHandlerException {
        logger.finer("PRIVMSG contains an 'op' command ...");
        // get the channel argument and the nick to op
        // but first check we have the right number of parameters
        // we can op up to 3 nicks at once
        if ((params.size() > 1) && (params.size() < 5)) {
            String channelName = (String)params.get(0);
            StringBuffer nicks = new StringBuffer();
            for (int i = 1; i < params.size(); i++) {
                String nickname = (String)params.get(i);
                nicks.append(nickname);
                if (!(i == (params.size()-1))) {
                    nicks.append(" ");
                }
            }
            logger.finer(StringTool.cat(new String[] {
                "Opping ",
                nicks.toString(),
                " on ",
                channelName,
                " ..."
            }));
            Channel myChannel = getChannel(channelName);
            if (myChannel != null) {
                BotUserManagerInterface botUserManager = DefaultBotUserManager.getInstance();
                if (botUserManager.canOp(channelUser, myChannel))
                    this.MODE(channelName, "+o", nicks.toString());
                else logger.fine(StringTool.cat(new String[] {
                    "PRIVMSG 'op' not allowed for ",
                    channelUser.getNick(), " on ",
                    channelName, " ..."}));
            }
            else logger.fine(StringTool.cat(new String[] {
                    "PRIVMSG 'op' channel ",
                    channelName, " is not one of mine ..."}));
        }
        else logger.warning("PRIVMSG 'op' command contained wrong parameters ...");
    }
    
    private void handleDeop(ChannelUser channelUser, List params) throws MessageHandlerException {
        logger.finer("PRIVMSG contains a 'deop' command ...");
        // get the channel argument and the nick to deop
        // but first check we have the right number of parameters
        // we can deop up to 3 nicks at once
        if ((params.size() > 1) && (params.size() < 5)) {
            String channelName = (String)params.get(0);
            StringBuffer nicks = new StringBuffer();
            for (int i = 1; i < params.size(); i++) {
                String nickname = (String)params.get(i);
                nicks.append(nickname);
                if (!(i == (params.size()-1))) {
                    nicks.append(" ");
                }
            }
            logger.finer(StringTool.cat(new String[] {
                "De-opping ",
                nicks.toString(),
                " on ",
                channelName,
                " ..."
            }));
            Channel myChannel = getChannel(channelName);
            if (myChannel != null) {
                BotUserManagerInterface botUserManager = DefaultBotUserManager.getInstance();
                if (botUserManager.canDeop(channelUser, myChannel))
                    this.MODE(channelName, "-o", nicks.toString());
                else logger.fine(StringTool.cat(new String[] {
                    "PRIVMSG 'deop' not allowed for ",
                    channelUser.getNick(), " on ",
                    channelName, " ..."}));
            }
            else logger.fine(StringTool.cat(new String[] {
                    "PRIVMSG 'deop' channel ",
                    channelName, " is not one of mine ..."}));
        }
        else logger.warning("PRIVMSG 'deop' command contained wrong parameters ...");
    }

    private void handleVoice(ChannelUser channelUser, List params) throws MessageHandlerException {
        logger.finer("PRIVMSG contains a 'voice' command ...");
        // get the channel argument and the nick to voice
        // but first check we have the right number of parameters
        // we can op up to 3 nicks at once
        if ((params.size() > 1) && (params.size() < 5)) {
            String channelName = (String)params.get(0);
            StringBuffer nicks = new StringBuffer();
            for (int i = 1; i < params.size(); i++) {
                String nickname = (String)params.get(i);
                nicks.append(nickname);
                if (!(i == (params.size()-1))) {
                    nicks.append(" ");
                }
            }
            logger.finer(StringTool.cat(new String[] {
                "Voicing ",
                nicks.toString(),
                " on ",
                channelName,
                " ..."
            }));
            Channel myChannel = getChannel(channelName);
            if (myChannel != null) {
                BotUserManagerInterface botUserManager = DefaultBotUserManager.getInstance();
                if (botUserManager.canVoice(channelUser, myChannel))
                    this.MODE(channelName, "+v", nicks.toString());
                else logger.fine(StringTool.cat(new String[] {
                    "PRIVMSG 'voice' not allowed for ",
                    channelUser.getNick(), " on ",
                    channelName, " ..."}));
            }
            else logger.fine(StringTool.cat(new String[] {
                    "PRIVMSG 'voice' channel ",
                    channelName, " is not one of mine ..."}));
        }
        else logger.warning("PRIVMSG 'voice' command contained wrong parameters ...");
    }
    
    private void handleDevoice(ChannelUser channelUser, List params) throws MessageHandlerException {
        logger.finer("PRIVMSG contains a 'devoice' command ...");
        // get the channel argument and the nick to devoice
        // but first check we have the right number of parameters
        // we can deop up to 3 nicks at once
        if ((params.size() > 1) && (params.size() < 5)) {
            String channelName = (String)params.get(0);
            StringBuffer nicks = new StringBuffer();
            for (int i = 1; i < params.size(); i++) {
                String nickname = (String)params.get(i);
                nicks.append(nickname);
                if (!(i == (params.size()-1))) {
                    nicks.append(" ");
                }
            }
            logger.finer(StringTool.cat(new String[] {
                "De-voicing ",
                nicks.toString(),
                " on ",
                channelName,
                " ..."
            }));
            Channel myChannel = getChannel(channelName);
            if (myChannel != null) {
                BotUserManagerInterface botUserManager = DefaultBotUserManager.getInstance();
                if (botUserManager.canDevoice(channelUser, myChannel))
                    this.MODE(channelName, "-v", nicks.toString());
                else logger.fine(StringTool.cat(new String[] {
                    "PRIVMSG 'devoice' not allowed for ",
                    channelUser.getNick(), " on ",
                    channelName, " ..."}));
            }
            else logger.fine(StringTool.cat(new String[] {
                    "PRIVMSG 'devoice' channel ",
                    channelName, " is not one of mine ..."}));
        }
        else logger.warning("PRIVMSG 'devoice' command contained wrong parameters ...");
    }

    private boolean addresseeIsMe(String addressee) {
        return (!(addressee.startsWith("#") || addressee.startsWith("+") ||
                  addressee.startsWith("!") || addressee.startsWith("&")));
    }
    
/*    private boolean addresseeIsChannel(String addressee) {
        return (addressee.startsWith("#") || addressee.startsWith("+") ||
                  addressee.startsWith("!") || addressee.startsWith("&"));
    }
*/    
    private Channel getChannel(String channelName) {
        List channels = env.getChannels();
        Channel myChannel = null;
        boolean foundChannel = false;
        for (int i = 0; i < channels.size(); i++) {
            myChannel = (Channel)channels.get(i);
            if (myChannel.getName().equals(channelName)) {
                foundChannel = true;
                break;
            }
        }
        if (foundChannel) return myChannel;
        else return null;
    }

    private void addJoiner(ChannelUser joiner, String channelName) {
        // iterate over my channels
        List channels = env.getChannels();
        for (int i = 0; i < channels.size(); i++) {
            Channel channel = (Channel)channels.get(i);
            // check the channel is one of mine
            if ((channel.getName()).equals(channelName)) {
                logger.finer("This is one of our channels ...");
                // iterate over the users
                List channelUsers = channel.getUsers();
                channelUsers.add(joiner);
            }
        }

    }

    private void removeParter(ChannelUser parter, String channelName) {
        // iterate over my channels
        List channels = env.getChannels();
        for (int i = 0; i < channels.size(); i++) {
            Channel channel = (Channel)channels.get(i);
            // check the channel is one of mine
            if ((channel.getName()).equals(channelName)) {
                logger.finer("This is one of our channels ...");
                // iterate over the users, remove the parter
                List channelUsers = channel.getUsers();
                channelUsers.remove(parter);
            }
        }
    }

    private void removeQuitter(ChannelUser quitter) {
        // iterate over my channels
        List channels = env.getChannels();
        for (int i = 0; i < channels.size(); i++) {
            Channel channel = (Channel)channels.get(i);
            // iterate over the users, remove the parter
            List channelUsers = channel.getUsers();
            channelUsers.remove(quitter);
        }
        
    }

    /** 3.2.3 Mode message
     * @param channel The channel for the mode message.
     * @param modes The modes being applied.
     * @param params The mode parameters.
     * @throws MessageHandlerException Thrown if any handler fails to handle our dispatched message.
     */
    public void MODE(String channel, String modes, String params) throws MessageHandlerException {
        // construct an IRCCommandEvent
        // use env to fire it
        // out command handlers will pick it up
        if (env != null) {
            logger.fine("Handling MODE message ...");
            IRCCommandEvent evt = new IRCCommandEvent(env, MessageNames.CHANNEL_MODE);
            evt.addParameter(channel);
            evt.addParameter(modes);
            evt.addParameter(params);
            logger.finer("Firing command event ...");
            env.fireIRCCommandEvent(evt);
        }
        else logger.warning("Bot environment was null ...");
    }
    
    public void WHO(String mask, String operator) throws MessageHandlerException {
        if (env != null) {
            logger.fine("Handling WHO message ...");
            IRCCommandEvent evt = new IRCCommandEvent(env, MessageNames.WHO);
            evt.addParameter(mask);
            evt.addParameter(operator);
            logger.finer("Firing command event ...");
            env.fireIRCCommandEvent(evt);
        }
        else logger.warning("Bot environment was null ...");
    }
}
