/*
 * NewMessageFactory.java
 *
 * Created on 24 July 2002, 13:46
 */

package net.munki.irc.message;

import net.munki.irc.protocol.rfc2812.MessageNames;
import net.munki.irc.protocol.rfc2812.ReplyNames;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MessageFactory {
    
    public static final String UNKNOWN = "unknown";
    public static final String PUBLIC = "public";
    public static final String PRIVATE = "private";
    public static final String SECRET = "secret";

    private MessageFactory() {
    }

    /**
     * @param message
     * @return
     */    
    public static GenericMessageInterface getMessage(String message) {

        GenericMessageInterface gmi = null;
        
        // check for PING
        
        if (message.startsWith(MessageNames.PING)) {
            
            // create a ping message object
            gmi = MessageFactory.createPingMessage(message);
            
        }
        
        // check for a prefix ':' indicating user or server message
        
        else if (message.startsWith(":")) {
            
            // create a user or server message
            gmi = MessageFactory.createPrefixMessage(message);
            
        }
        
        return gmi;
    }
    
    private static CommandMessageInterface createPingMessage(String message) {
        
        // Strip the prefix
        String parameters = message.substring(message.indexOf(":")+1);
        
        // Add the rest to the message

        return new PingMessage(parameters);
    }
    
    private static GenericMessageInterface createPrefixMessage(String message) {
        
        GenericMessageInterface gmi = null;
        
        // The prefix tells us who the message is from
        String prefix = message.substring(message.indexOf(":")+1, message.indexOf(" "));

        // The fix is what comes after the prefix
        String fix = message.substring(message.indexOf(" ")+1);

        // The command is the first part of the fix
        String command = fix.substring(0, fix.indexOf(" "));

        // The arguments is the last part of the fix
        String arguments = fix.substring(fix.indexOf(" ")+1);
        
        // The command can be a 3 digit numeric reply code
        if (MessageFactory.isValidNumericReply(command)) {
            // the command is a valid reply message
            gmi = MessageFactory.createReplyMessage(prefix, command, arguments);
        }
        
        // Or it can be a valid IRC command
        else if (MessageFactory.isValidIRCCommand(command)) {
            // we have a valid irc command
            gmi = MessageFactory.createCommandMessage(prefix, command, arguments);
        }

        
        return gmi;
    }
    
    private static ReplyMessageInterface createReplyMessage(String prefix, String command, String arguments) {
        
        ReplyMessageInterface rmi = null;

        switch (command) {
            case ReplyNames.RPL_NAMREPLY -> {

                // We are getting a name reply
                // The first char identifies the channel type
                String channelModifier = arguments.substring(0, 1);
                // Then comes the channel name
                String channel = arguments.substring(arguments.indexOf(" ") + 1, arguments.indexOf(" :"));
                // Then the list of nicknames
                String nickList = arguments.substring(arguments.indexOf(" :") + 2);

                String channelType = switch (channelModifier) {
                    case "=" -> MessageFactory.PUBLIC;
                    case "*" -> MessageFactory.PRIVATE;
                    case "@" -> MessageFactory.SECRET;
                    default -> MessageFactory.UNKNOWN;
                };

                // Set the channel type string according to our first char

                // Build a list of names from the string of names
                StringTokenizer st = new StringTokenizer(nickList);
                String[] names = new String[st.countTokens()];
                int count = 0;
                while (st.hasMoreTokens()) {
                    String modifiedNick = st.nextToken();
                    String nick;
                    if (modifiedNick.startsWith("@") || modifiedNick.startsWith("+")) {
                        nick = modifiedNick.substring(1);
                    } else {
                        nick = modifiedNick;
                    }
                    names[count] = nick;
                    count++;
                }

                // prefix = server
                rmi = new NamesReplyMessage(prefix, channelType, channel, names);
                break;
            }
            case ReplyNames.RPL_WHOREPLY -> {

                // this is a response to a /who command
                String hopAndReal = arguments.substring(arguments.indexOf(":") + 1);
                String hop = hopAndReal.substring(0, hopAndReal.indexOf(" "));
                String real = hopAndReal.substring(hopAndReal.indexOf(" ") + 1);

                String upToColon = arguments.substring(0, arguments.indexOf(":"));
                String asterisk = "";
                String userStatus = "";
                if (upToColon.indexOf('*') > 0) asterisk = "*";
                if (upToColon.indexOf('@') > 0) userStatus = "@";
                else if (upToColon.indexOf('+') > 0) userStatus = "+";

                StringTokenizer st = new StringTokenizer(upToColon);
                String[] tokens = new String[st.countTokens()];
                int tokenCount = 0;
                while (st.hasMoreTokens()) {
                    tokens[tokenCount] = st.nextToken();
                    tokenCount++;
                }
                // String rplTo = "";
                String channel = "";
                String user = "";
                String host = "";
                String server = "";
                String nick = "";
                String HGToken = "";
                if (tokens.length >= 7) {
                    // rplTo = tokens[0];
                    channel = tokens[1];
                    user = tokens[2];
                    host = tokens[3];
                    server = tokens[4];
                    nick = tokens[5];
                    HGToken = tokens[6];
                }
                String HG = "";
                if (HGToken.startsWith("H")) HG = "H";
                else if (HGToken.startsWith("G")) HG = "G";

                rmi = new WhoReplyMessage(channel, user, host, server, nick, HG, asterisk, userStatus, hop, real);
                break;
            }
            case ReplyNames.ERR_NICKNAMEINUSE -> {

                // We are getting an error because our chosen nickname
                // is already taken by someone else

                // The first argument is the nickname causing the problem
                String nick = arguments.substring(0, arguments.indexOf(" :"));
                // The next bit is the server message
                String message = arguments.substring(arguments.indexOf(" :") + 2);

                rmi = new NicknameInUseMessage(prefix, nick, message);
                break;
            }
            case ReplyNames.RPL_WELCOME -> {

                // We are getting a welcome message

                // Break up the message
                StringTokenizer st = new StringTokenizer(arguments);
                List list = new ArrayList();
                while (st.hasMoreTokens()) {
                    list.add(st.nextToken());
                }

                // Get the <nick>!<user>@<host> mask at the end
                String mask = "";
                StringBuffer message = new StringBuffer();
                Object[] tokens = list.toArray();
                if (tokens.length > 2) {
                    mask = (String) tokens[tokens.length - 1];
                    for (int i = 0; i < tokens.length - 1; i++) {
                        message.append((String) tokens[i]);
                        if (i != tokens.length - 2) message.append(" ");
                    }
                }

                rmi = new WelcomeMessage(message.toString(), mask);
                break;
            }
        }

        return rmi;
    }
    
    private static CommandMessageInterface createCommandMessage(String prefix, String command, String arguments) {
        
        CommandMessageInterface cmi = null;
        String from;
        String usermod = "";
        String modifier = "";
        String user;
        String host = "";
        
        // If we have a user and host specified
        // get the user + modifier and the host name
        if (prefix.indexOf("@") > -1) {
            // we have a host
            host = prefix.substring(prefix.indexOf("@")+1);
            if (prefix.indexOf("!") > -1) {
                // we have a user and therefore a nickname up to '!'
                usermod = prefix.substring(prefix.indexOf("!")+1, prefix.indexOf("@"));
                from = prefix.substring(0, prefix.indexOf("!"));
            }
            else {
                // no user but we have a nickname up to '@'
                from = prefix.substring(0, prefix.indexOf("@"));
            }
        }
        else {
            // no user or host but a nickname or servername
            from = prefix;
        }
        
        // Separate out our user and modifier if there is one
        if (usermod.startsWith("~") || usermod.startsWith("-") || usermod.startsWith("^")) {
            modifier = usermod.substring(0,1);
            user = usermod.substring(1);
        }
        else user = usermod;
        
        // Check what command we have been sent

        // is it really a channel mode?
        // parse the arguments to find out
        // if it is, construct a channel mode message
        // if not, then its a user mode message
        // which we will need to handle here too
        // since there is no distinction between the two
        // command names in the protocol
        switch (command) {
            case MessageNames.JOIN -> {
                String channel = arguments.substring(arguments.indexOf(":") + 1);
                cmi = new JoinMessage(from, modifier, user, host, channel);
                break;
            }
            case MessageNames.PART -> {
                String channel = "";
                String partMessage = "";
                if (arguments.indexOf(" :") > -1) {
                    channel = arguments.substring(0, arguments.indexOf(" :"));
                    partMessage = arguments.substring(arguments.indexOf(":") + 1);
                } else {
                    channel = arguments;
                }
                cmi = new PartMessage(from, modifier, user, host, channel, partMessage);
                break;
            }
            case MessageNames.KICK -> {
                String channel = arguments.substring(0, arguments.indexOf(" "));
                String nickToKick = arguments.substring(arguments.indexOf(" ") + 1);
                cmi = new KickMessage(from, modifier, user, host, channel, nickToKick);
                break;
            }
            case MessageNames.QUIT -> {
                String message = arguments.substring(arguments.indexOf(":") + 1);
                cmi = new QuitMessage(from, modifier, user, host, message);
                break;
            }
            case MessageNames.PRIVMSG -> {
                String addressee = arguments.substring(0, arguments.indexOf(" :"));
                String message = arguments.substring(arguments.indexOf(":") + 1);
                cmi = new PrivmsgMessage(from, modifier, user, host, addressee, message);
                break;
            }
            case MessageNames.CHANNEL_MODE -> {
                String target = arguments.substring(0, arguments.indexOf(" "));
                if (target.startsWith("#") || target.startsWith("+") ||
                        target.startsWith("!") || target.startsWith("&")) {

                    // we have a channel
                    String modesAndParams = arguments.substring(arguments.indexOf(" ") + 1);

                    // separate the modes from the mode params and pass separately

                    String modes = modesAndParams.substring(0, modesAndParams.indexOf(" "));
                    String params = modesAndParams.substring(modesAndParams.indexOf(" ") + 1);

                    cmi = new ChannelModeMessage(from, modifier, user, host, target, modes, params);
                } else {

                    // we have a user
                }
            }
        }

        return cmi;
    }
    
    /**
     * @param command
     * @return
     */    
    public static boolean isValidNumericReply(String command) {
        
        // Use reflection to create a list of the fields and
        // iterate over them.
        
        boolean success = false;
        try {
            Class c = Class.forName("net.munki.irc.protocol.rfc2812.ReplyNames");
            Field[] fields = c.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                String value = (String)(fields[i].get(new Object()));
                if (value.equals(command)) {
                    success = true;
                    break;
                }
            }
        }
        catch (ClassNotFoundException cnfe) {
            success = false;
        }
        catch (IllegalAccessException iae) {
            success = false;
        }
        return success;
    }
    
    /**
     * @param command
     * @return
     */    
    public static boolean isValidIRCCommand(String command) {
        // Use reflection to create a list of the fields and
        // iterate over them.
        
        boolean success = false;
        try {
            Class c = Class.forName("net.munki.irc.protocol.rfc2812.MessageNames");
            Field[] fields = c.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                String value = (String)(fields[i].get(new Object()));
                if (value.equals(command)) {
                    success = true;
                    break;
                }
            }
        }
        catch (ClassNotFoundException cnfe) {
            success = false;
        }
        catch (IllegalAccessException iae) {
            success = false;
        }
        return success;
    }

}
