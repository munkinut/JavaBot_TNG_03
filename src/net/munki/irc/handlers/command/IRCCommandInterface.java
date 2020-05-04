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
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    /** Writes to the connection.
//     * @param msg Message to write
//     * @throws IOException Thrown if an error occurs during writing
//     */
//    void write(String msg) throws IOException;
// --Commented out by Inspection STOP (04/05/2020 21:37)

    /** 3.4.7 Connect message
     * @param target
     * @param port
     * @param remote
     * @throws MessageHandlerException
     */
    void CONNECT(String target, String port, String remote) throws MessageHandlerException;
    
    /** 3.4.5 Links message
     * @param remote
     * @param mask
     * @throws MessageHandlerException
     */
    void LINKS(String remote, String mask) throws MessageHandlerException;
    
    /** 3.5.1 Servlist message
     * @param mask
     * @param type
     * @throws MessageHandlerException
     */
    void SERVLIST(String mask, String type) throws MessageHandlerException;
    
    /** 3.5.2 Squery
     * @param service
     * @param text
     * @throws MessageHandlerException
     */
    void SQUERY(String service, String text) throws MessageHandlerException;
    
    /** 3.1.6 Service Message
     * @param nick
     * @param reserved_1
     * @param distribution
     * @param type
     * @param reserved_2
     * @param info
     * @throws MessageHandlerException
     */
    void SERVICE(String nick, String reserved_1, String distribution, String type, String reserved_2, String info) throws MessageHandlerException;
    
    /** 3.1.7 Quit
     * @param message
     * @throws MessageHandlerException
     */
    void QUIT(String message) throws MessageHandlerException;
    
    /** 3.7.1 Kill message
     * @param nick
     * @param comment
     * @throws MessageHandlerException
     */
    void KILL(String nick, String comment) throws MessageHandlerException;
    
    /** 4.5 Summon message
     * @param user
     * @param target
     * @param channel
     * @throws MessageHandlerException
     */
    void SUMMON(String user, String target, String channel) throws MessageHandlerException;
    
    /** 3.6.3 Whowas
     * @param nick
     * @param count
     * @param target
     * @throws MessageHandlerException
     */
    void WHOWAS(String[] nick, String count, String target) throws MessageHandlerException;
    
    /** 4.7 Operwall message
     * @param message
     * @throws MessageHandlerException
     */
    void WALLOPS(String message) throws MessageHandlerException;
    
    /** 3.7.4 Error
     * @param message
     * @throws MessageHandlerException
     */
    void ERROR(String message) throws MessageHandlerException;
    
    /** 3.4.9 Admin Command
     * @param target
     * @throws MessageHandlerException
     */
    void ADMIN(String target) throws MessageHandlerException;
    
    /** 4.2 Rehash message
     * @throws MessageHandlerException
     */
    void REHASH() throws MessageHandlerException;
    
    /** 3.4.2 Lusers message
     * @param mask
     * @param target
     * @throws MessageHandlerException
     */
    void LUSERS(String mask, String target) throws MessageHandlerException;
    
    /** 3.6.2 Whois query
     * @param target
     * @param mask
     * @throws MessageHandlerException
     */
    void WHOIS(String target, String[] mask) throws MessageHandlerException;
    
    /** 3.4.4 Stats message
     * @param query
     * @param target
     * @throws MessageHandlerException
     */
    void STATS(String query, String target) throws MessageHandlerException;
    
    /** 3.2.6 List message
     * @param channels
     * @param target
     * @throws MessageHandlerException
     */
    void LIST(String[] channels, String target) throws MessageHandlerException;
    
    /** 3.1.4 Oper Message
     * @param name
     * @param pass
     * @throws MessageHandlerException
     */
    void OPER(String name, String pass) throws MessageHandlerException;
    
    /**
     * @param server_1
     * @param server_2
     * @throws MessageHandlerException
     */
    void PONG(String server_1, String server_2) throws MessageHandlerException;
    
    /** 4.6 Users
     * @param target
     * @throws MessageHandlerException
     */
    void USERS(String target) throws MessageHandlerException;
    
    /** 3.4.8 Trace message
     * @param target
     * @throws MessageHandlerException
     */
    void TRACE(String target) throws MessageHandlerException;
    
    /** 4.4 Restart message
     * @throws MessageHandlerException
     */
    void RESTART() throws MessageHandlerException;
    
    /** 3.4.10 Info Command
     * @param target
     * @throws MessageHandlerException
     */
    void INFO(String target) throws MessageHandlerException;
    
    /** 3.2.8 Kick message
     * @param channels
     * @param nicks
     * @param message
     * @throws MessageHandlerException
     */
    void KICK(String[] channels, String[] nicks, String message) throws MessageHandlerException;
    
    /** 3.4.1 Motd message
     * @param target
     * @throws MessageHandlerException
     */
    void MOTD(String target) throws MessageHandlerException;
    
    /** 3.1.1 Password Message
     * @param pass
     * @throws MessageHandlerException
     */
    void PASS(String pass) throws MessageHandlerException;
    
    /** 3.3.2 Notice
     * @param target
     * @param text
     * @throws MessageHandlerException
     */
    void NOTICE(String target, String text) throws MessageHandlerException;
    
    /**
     * @param channels
     * @param keys
     * @throws MessageHandlerException
     */
    void JOIN(String[] channels, String[] keys) throws MessageHandlerException;
    
    /** 3.3.1 Private messages
     * @param target
     * @param text
     * @throws MessageHandlerException
     */
    void PRIVMSG(String target, String text) throws MessageHandlerException;
    
    /** 3.2.5 Names message
     * @param channel
     * @param target
     * @throws MessageHandlerException
     */
    void NAMES(String[] channel, String target) throws MessageHandlerException;
    
    /** 3.4.6 Time message
     * @param target
     * @throws MessageHandlerException
     */
    void TIME(String target) throws MessageHandlerException;
    
    /** 3.2.2 Part message
     * @param channels
     * @param message
     * @throws MessageHandlerException
     */
    void PART(String[] channels, String message) throws MessageHandlerException;
    
    /** 3.1.5 Mode Message
     * @param nick
     * @param modes
     * @throws MessageHandlerException
     */
    void MODE(String nick, String modes) throws MessageHandlerException;
    
    /** 3.2.3 Mode message
     * @param channel
     * @param modes
     * @param params
     * @throws MessageHandlerException
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
     * @throws MessageHandlerException
     */
    void TOPIC(String channel, String topic) throws MessageHandlerException;
    
    /** 3.7.2 Ping message
     * @param server_1
     * @param server_2
     * @throws MessageHandlerException
     */
    void PING(String server_1, String server_2) throws MessageHandlerException;
    
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
     * @throws MessageHandlerException
     */
    void AWAY(String text) throws MessageHandlerException;
    
    /** 3.2.7 Invite message
     * @param nickname
     * @param channel
     * @throws MessageHandlerException
     */
    void INVITE(String nickname, String channel) throws MessageHandlerException;
    
    /** 4.8 Userhost message
     * @param nicks
     * @throws MessageHandlerException
     */
    void USERHOST(String[] nicks) throws MessageHandlerException;
    
    /** 3.1.2 Nick Message
     * @param nick
     * @throws MessageHandlerException
     */
    void NICK(String nick) throws MessageHandlerException;
    
    /** 4.3 Die message
     * @throws MessageHandlerException
     */
    void DIE() throws MessageHandlerException;
    
    /** 3.4.3 Version message
     * @param target
     * @throws MessageHandlerException
     */
    void VERSION(String target) throws MessageHandlerException;
    
    /** 4.9 Ison message
     * @param nicks
     * @throws MessageHandlerException
     */
    void ISON(String[] nicks) throws MessageHandlerException;
    
    /** 3.1.8 SQuit
     * @param server
     * @param comment
     * @throws MessageHandlerException
     */
    void SQUIT(String server, String comment) throws MessageHandlerException;
    
    /** 3.6.1 Who query
     * @param mask
     * @param operator
     * @throws MessageHandlerException
     */
    void WHO(String mask, String operator) throws MessageHandlerException;
    
    /** 3.2.1 Join message
     * @param channels
     * @throws MessageHandlerException
     */
    void JOIN(String[] channels) throws MessageHandlerException;
    
}

