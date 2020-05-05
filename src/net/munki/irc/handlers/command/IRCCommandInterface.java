/*
 * IRCCommandInterface.java
 *
 * Created on 23 July 2002, 11:42
 */

package net.munki.irc.handlers.command;

import net.munki.irc.connection.Connection;
import net.munki.irc.protocol.rfc2812.MessageHandlerException;
import net.munki.irc.protocol.rfc2812.MessageHandlerInterface;

import java.io.IOException;

/** Extends the CommandHandlerInterface adding connection handling capabilities.
 */
public interface IRCCommandInterface extends MessageHandlerInterface {

    /** Sets the connection.
     * @param connection The connection
     */
    void setConnection(Connection connection);
    
    /** Writes to the connection.
     * @param msg Message to write
     * @throws IOException Thrown if an error occurs during writing
     */
    void write(String msg) throws IOException;

    /** 3.4.7 Connect message
     * @param target
     * @param port
     * @param remote
     */
    void CONNECT(String target, String port, String remote);
    
    /** 3.4.5 Links message
     * @param remote
     * @param mask
     */
    void LINKS(String remote, String mask);
    
    /** 3.5.1 Servlist message
     * @param mask
     * @param type
     */
    void SERVLIST(String mask, String type);
    
    /** 3.5.2 Squery
     * @param service
     * @param text
     */
    void SQUERY(String service, String text);
    
    /** 3.1.6 Service Message
     * @param nick
     * @param reserved_1
     * @param distribution
     * @param type
     * @param reserved_2
     * @param info
     */
    void SERVICE(String nick, String reserved_1, String distribution, String type, String reserved_2, String info);
    
    /** 3.1.7 Quit
     * @param message
     */
    void QUIT(String message);
    
    /** 3.7.1 Kill message
     * @param nick
     * @param comment
     */
    void KILL(String nick, String comment);
    
    /** 4.5 Summon message
     * @param user
     * @param target
     * @param channel
     */
    void SUMMON(String user, String target, String channel);
    
    /** 3.6.3 Whowas
     * @param nick
     * @param count
     * @param target
     */
    void WHOWAS(String[] nick, String count, String target);
    
    /** 4.7 Operwall message
     * @param message
     */
    void WALLOPS(String message);
    
    /** 3.7.4 Error
     * @param message
     */
    void ERROR(String message);
    
    /** 3.4.9 Admin Command
     * @param target
     */
    void ADMIN(String target);
    
    /** 4.2 Rehash message
     */
    void REHASH();
    
    /** 3.4.2 Lusers message
     * @param mask
     * @param target
     */
    void LUSERS(String mask, String target);
    
    /** 3.6.2 Whois query
     * @param target
     * @param mask
     */
    void WHOIS(String target, String[] mask);
    
    /** 3.4.4 Stats message
     * @param query
     * @param target
     */
    void STATS(String query, String target);
    
    /** 3.2.6 List message
     * @param channels
     * @param target
     */
    void LIST(String[] channels, String target);
    
    /** 3.1.4 Oper Message
     * @param name
     * @param pass
     */
    void OPER(String name, String pass);
    
    /**
     * @param server_1
     * @param server_2
     */
    void PONG(String server_1, String server_2);
    
    /** 4.6 Users
     * @param target
     */
    void USERS(String target);
    
    /** 3.4.8 Trace message
     * @param target
     */
    void TRACE(String target);
    
    /** 4.4 Restart message
     */
    void RESTART();
    
    /** 3.4.10 Info Command
     * @param target
     */
    void INFO(String target);
    
    /** 3.2.8 Kick message
     * @param channels
     * @param nicks
     * @param message
     */
    void KICK(String[] channels, String[] nicks, String message);
    
    /** 3.4.1 Motd message
     * @param target
     */
    void MOTD(String target);
    
    /** 3.1.1 Password Message
     * @param pass
     */
    void PASS(String pass);
    
    /** 3.3.2 Notice
     * @param target
     * @param text
     */
    void NOTICE(String target, String text);
    
    /**
     * @param channels
     * @param keys
     */
    void JOIN(String[] channels, String[] keys);
    
    /** 3.3.1 Private messages
     * @param target
     * @param text
     * @throws MessageHandlerException
     */
    void PRIVMSG(String target, String text) throws MessageHandlerException;
    
    /** 3.2.5 Names message
     * @param channel
     * @param target
     */
    void NAMES(String[] channel, String target);
    
    /** 3.4.6 Time message
     * @param target
     */
    void TIME(String target);
    
    /** 3.2.2 Part message
     * @param channels
     * @param message
     */
    void PART(String[] channels, String message);
    
    /** 3.1.5 Mode Message
     * @param nick
     * @param modes
     */
    void MODE(String nick, String modes);
    
    /** 3.2.3 Mode message
     * @param channel
     * @param modes
     * @param params
     */
    void MODE(String channel, String modes, String params) throws MessageHandlerException;
    
    /** 3.7.3 Pong message
     * @param server_1
     * @throws MessageHandlerException
     */
    void PONG(String server_1) throws MessageHandlerException;
    
    /** 3.2.4 Topic message
     * @param channel
     * @param topic
     */
    void TOPIC(String channel, String topic);
    
    /** 3.7.2 Ping message
     * @param server_1
     * @param server_2
     */
    void PING(String server_1, String server_2);
    
    /** 3.1.3 User Message
     * @param user
     * @param mode
     * @param unused
     * @param real
     * @throws MessageHandlerException
     */
    void USER(String user, String mode, String unused, String real) throws MessageHandlerException;
    
    /** 4.1 Away
     * @param text
     */
    void AWAY(String text);
    
    /** 3.2.7 Invite message
     * @param nickname
     * @param channel
     */
    void INVITE(String nickname, String channel);
    
    /** 4.8 Userhost message
     * @param nicks
     */
    void USERHOST(String[] nicks);
    
    /** 3.1.2 Nick Message
     * @param nick
     * @throws MessageHandlerException
     */
    void NICK(String nick) throws MessageHandlerException;
    
    /** 4.3 Die message
     */
    void DIE();
    
    /** 3.4.3 Version message
     * @param target
     */
    void VERSION(String target);
    
    /** 4.9 Ison message
     * @param nicks
     */
    void ISON(String[] nicks);
    
    /** 3.1.8 SQuit
     * @param server
     * @param comment
     */
    void SQUIT(String server, String comment);
    
    /** 3.6.1 Who query
     * @param mask
     * @param operator
     */
    void WHO(String mask, String operator) throws MessageHandlerException;
    
    /** 3.2.1 Join message
     * @param channels
     * @throws MessageHandlerException
     */
    void JOIN(String[] channels) throws MessageHandlerException;
    
}

