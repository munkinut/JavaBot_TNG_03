/*
 * IRCMessageInterface.java
 *
 * Created on 23 July 2002, 14:56
 */

package net.munki.irc.handlers.message;

import net.munki.irc.protocol.rfc2812.MessageHandlerException;
import net.munki.irc.protocol.rfc2812.MessageHandlerInterface;

import java.util.ArrayList;

/** Deinfos IRC message types. */
public interface IRCMessageInterface extends MessageHandlerInterface {

    /** 3.5.2 Squery
     * @param service
     * @param text
     */
    void SQUERY(String service, String text);
    
    /** 3.7.2 Ping message
     * @param server_1
     * @param server_2
     */
    void PING(String server_1, String server_2);
    
    /** 3.4.7 Connect message
     * @param target
     * @param port
     * @param remote
     */
    void CONNECT(String target, String port, String remote);
    
    /** 4.3 Die message
     */
    void DIE();
    
    /** 3.1.1 Password Message
     * @param pass
     */
    void PASS(String pass);
    
    /** 3.2.4 Topic message
     * @param channel
     * @param topic
     */
    void TOPIC(String channel, String topic);
    
    /** 3.4.8 Trace message
     * @param target
     */
    void TRACE(String target);
    
    /** 3.2.7 Invite message
     * @param nickname
     * @param channel
     */
    void INVITE(String nickname, String channel);
    
    /** 3.4.3 Version message
     * @param target
     */
    void VERSION(String target);
    
    /**
     * @param channels
     * @param keys
     */
    void JOIN(ArrayList<String> channels, ArrayList<String> keys);
    
    /** 3.2.6 List message
     * @param channels
     * @param target
     */
    void LIST(String[] channels, String target);
    
    /** 4.9 Ison message
     * @param nicks
     */
    void ISON(String[] nicks);
    
    /** 3.7.1 Kill message
     * @param nick
     * @param comment
     */
    void KILL(String nick, String comment);
    
    /** 3.4.10 Info Command
     * @param target
     */
    void INFO(String target);
    
    /** 3.7.4 Error
     * @param message
     */
    void ERROR(String message);
    
    /** 3.4.6 Time message
     * @param target
     */
    void TIME(String target);
    
    /** 3.6.1 Who query
     * @param mask
     * @param operator
     */
    void WHO(String mask, String operator) throws MessageHandlerException;
    
    /** 3.7.3 Pong message
     * @param server_1
     * @throws MessageHandlerException
     */
    void PONG(String server_1) throws MessageHandlerException;
    
    /** 3.2.2 Part message
     * @param channels
     * @param message
     */
    void PART(String[] channels, String message);
    
    /** 3.1.3 User Message
     * @param user
     * @param mode
     * @param unused
     * @param real
     */
    void USER(String user, String mode, String unused, String real);
    
    /** 3.2.8 Kick message
     * @param channels
     * @param nicks
     * @param message
     */
    void KICK(String[] channels, String[] nicks, String message);
    
    /** 3.4.5 Links message
     * @param remote
     * @param mask
     */
    void LINKS(String remote, String mask);
    
    /** 4.5 Summon message
     * @param user
     * @param target
     * @param channel
     */
    void SUMMON(String user, String target, String channel);
    
    /** 3.2.1 Join message
     * @param channels
     */
    void JOIN(ArrayList<String> channels);
    
    /**
     * @param server_1
     * @param server_2
     */
    void PONG(String server_1, String server_2);
    
    /** 4.7 Operwall message
     * @param message
     */
    void WALLOPS(String message);
    
    /** 3.4.2 Lusers message
     * @param mask
     * @param target
     */
    void LUSERS(String mask, String target);
    
    /** 3.4.1 Motd message
     * @param target
     */
    void MOTD(String target);
    
    /** 4.8 Userhost message
     * @param nicks
     */
    void USERHOST(String[] nicks);
    
    /** 3.3.2 Notice
     * @param target
     * @param text
     */
    void NOTICE(String target, String text);
    
    /** 4.1 Away
     * @param text
     */
    void AWAY(String text);
    
    /** 4.6 Users
     * @param target
     */
    void USERS(String target);
    
    /** 3.4.4 Stats message
     * @param query
     * @param target
     */
    void STATS(String query, String target);
    
    /** 3.1.4 Oper Message
     * @param name
     * @param pass
     */
    void OPER(String name, String pass);
    
    /** 3.1.2 Nick Message
     * @param nick
     */
    void NICK(String nick);
    
    /** 3.1.7 Quit
     * @param message
     */
    void QUIT(String message);
    
    /** 3.1.8 SQuit
     * @param server
     * @param comment
     */
    void SQUIT(String server, String comment);
    
    /** 3.5.1 Servlist message
     * @param mask
     * @param type
     */
    void SERVLIST(String mask, String type);
    
    /** 3.2.3 Mode message
     * @param channel
     * @param modes
     * @param params
     */
    void MODE(String channel, String modes, String params) throws MessageHandlerException;
    
    /** 3.1.5 Mode Message
     * @param nick
     * @param modes
     */
    void MODE(String nick, String modes);
    
    /** 3.4.9 Admin Command
     * @param target
     */
    void ADMIN(String target);
    
    /** 4.2 Rehash message
     */
    void REHASH();
    
    /** 3.6.2 Whois query
     * @param target
     * @param mask
     */
    void WHOIS(String target, String[] mask);
    
     /** 3.2.5 Names message
      * @param channel
      * @param target
      */
     void NAMES(String[] channel, String target);
    
    /** 3.6.3 Whowas
     * @param nick
     * @param count
     * @param target
     */
    void WHOWAS(String[] nick, String count, String target);
    
    /** 3.3.1 Private messages
     * @param target
     * @param text
     */
    void PRIVMSG(String target, String text);
    
    /** 4.4 Restart message
     */
    void RESTART();
    
    /** 3.1.6 Service Message
     * @param nick
     * @param reserved_1
     * @param distribution
     * @param type
     * @param reserved_2
     * @param info
     */
    void SERVICE(String nick, String reserved_1, String distribution, String type, String reserved_2, String info);
    
}

