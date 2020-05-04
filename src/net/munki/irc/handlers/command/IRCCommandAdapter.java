/*
 * IRCCommandAdapter.java
 *
 * Created on 20 July 2002, 22:59
 */

package net.munki.irc.handlers.command;

import net.munki.irc.connection.Connection;
import net.munki.irc.event.IRCCommandEvent;
import net.munki.irc.event.IRCCommandListener;
import net.munki.irc.protocol.rfc2812.MessageHandlerException;

import java.io.IOException;

/** Convenience adapter implementing the methods of IRCCommandInterface and IRCCommandListener.
 */
public abstract class IRCCommandAdapter implements IRCCommandInterface, IRCCommandListener {
    
    /** The connection on which to dispatch command events. */    
    protected Connection connection;

    /** Creates new BotCommandAdapter */
    public IRCCommandAdapter() {
        connection = null;
    }
    
    /** Initialises the adapter with a connection.
     * @param connection The connection
     */    
    public IRCCommandAdapter(Connection connection) {
        this.connection = connection;
    }
    
    /** Sets the connection.
     * @param connection The connection
     */    
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    /** Writes to the connection.
     * @param msg Message to write
     * @throws IOException Thrown if an error occurs writing to the connection
     */    
    public void write(String msg) throws IOException {
        if (connection != null) {
            connection.writeLine(msg);
        }
    }

    /** Dispatches command event objects, by examining them and passing them to an appropriate handler method.
     * This method is abstract, allowing event handling to be customized to requirements.
     * @param evt The event to dispatch
     * @throws MessageHandlerException Thrown if an error occurs during dispatching
     */    
    public abstract void dispatch(IRCCommandEvent evt) throws MessageHandlerException;
    
    /** 3.5.2 Squery
     * @param service
     * @param text
     */
    public void SQUERY(String service, String text) {
    }
    
    /** 3.7.2 Ping message
     * @param server_1
     * @param server_2
     */
    public void PING(String server_1, String server_2) {
    }
    
    /** 3.4.7 Connect message
     * @param target
     * @param port
     * @param remote
     */
    public void CONNECT(String target, String port, String remote) {
    }
    
    /** 4.3 Die message
     */
    public void DIE() {
    }
    
    /** 3.1.1 Password Message
     * @param pass
     */
    public void PASS(String pass) {
    }
    
    /** 3.2.4 Topic message
     * @param channel
     * @param topic
     */
    public void TOPIC(String channel, String topic) {
    }
    
    /** 3.4.8 Trace message
     * @param target
     */
    public void TRACE(String target) {
    }
    
    /** 3.2.7 Invite message
     * @param nickname
     * @param channel
     */
    public void INVITE(String nickname, String channel) {
    }
    
    /** 3.4.3 Version message
     * @param target
     */
    public void VERSION(String target) {
    }
    
    /** 3.2.1 Join message
     * @param channels
     * @param keys
     */    
    public void JOIN(String[] channels, String[] keys) {
    }
    
    /** 3.2.6 List message
     * @param channels
     * @param target
     */
    public void LIST(String[] channels, String target) {
    }
    
    /** 4.9 Ison message
     * @param nicks
     */
    public void ISON(String[] nicks) {
    }
    
    /** 3.7.1 Kill message
     * @param nick
     * @param comment
     */
    public void KILL(String nick, String comment) {
    }
    
    /** 3.4.10 Info Command
     * @param target
     */
    public void INFO(String target) {
    }
    
    /** 3.7.4 Error
     * @param message
     */
    public void ERROR(String message) {
    }
    
    /** 3.4.6 Time message
     * @param target
     */
    public void TIME(String target) {
    }
    
    /** 3.6.1 Who query
     * @param mask
     * @param operator
     */
    public void WHO(String mask, String operator) {
    }
    
    /** 3.7.3 Pong message
     * @param server_1
     * @throws MessageHandlerException
     */
    public void PONG(String server_1) throws MessageHandlerException {
    }
    
    /** 3.2.2 Part message
     * @param channels
     * @param message
     */
    public void PART(String[] channels, String message) {
    }
    
    /** 3.1.3 User Message
     * @param user
     * @param mode
     * @param unused
     * @param real
     * @throws MessageHandlerException
     */
    public void USER(String user, String mode, String unused, String real) throws MessageHandlerException {
    }
    
    /** 3.2.8 Kick message
     * @param channels
     * @param nicks
     * @param message
     */
    public void KICK(String[] channels, String[] nicks, String message) {
    }
    
    /** 3.4.5 Links message
     * @param remote
     * @param mask
     */
    public void LINKS(String remote, String mask) {
    }
    
    /** 4.5 Summon message
     * @param user
     * @param target
     * @param channel
     */
    public void SUMMON(String user, String target, String channel) {
    }
    
    /** 3.2.1 Join message
     * @param channels
     * @throws MessageHandlerException
     */
    public void JOIN(String[] channels) throws MessageHandlerException {
    }
    
    /** PONG messsage.
     * @param server_1
     * @param server_2
     */    
    public void PONG(String server_1, String server_2) {
    }
    
    /** 4.7 Operwall message
     * @param message
     */
    public void WALLOPS(String message) {
    }
    
    /** 3.4.2 Lusers message
     * @param mask
     * @param target
     */
    public void LUSERS(String mask, String target) {
    }
    
    /** 3.4.1 Motd message
     * @param target
     */
    public void MOTD(String target) {
    }
    
    /** 4.8 Userhost message
     * @param nicks
     */
    public void USERHOST(String[] nicks) {
    }
    
    /** 3.3.2 Notice
     * @param target
     * @param text
     */
    public void NOTICE(String target, String text) {
    }
    
    /** 4.1 Away
     * @param text
     */
    public void AWAY(String text) {
    }
    
    /** 4.6 Users
     * @param target
     */
    public void USERS(String target) {
    }
    
    /** 3.4.4 Stats message
     * @param query
     * @param target
     */
    public void STATS(String query, String target) {
    }
    
    /** 3.1.4 Oper Message
     * @param name
     * @param pass
     */
    public void OPER(String name, String pass) {
    }
    
    /** 3.1.2 Nick Message
     * @param nick
     * @throws MessageHandlerException
     */
    public void NICK(String nick) throws MessageHandlerException {
    }
    
    /** 3.1.7 Quit
     * @param message
     */
    public void QUIT(String message) {
    }
    
    /** 3.1.8 SQuit
     * @param server
     * @param comment
     */
    public void SQUIT(String server, String comment) {
    }
    
    /** 3.5.1 Servlist message
     * @param mask
     * @param type
     */
    public void SERVLIST(String mask, String type) {
    }
    
    /** 3.2.3 Mode message
     * @param channel
     * @param modes
     * @param params
     */
    public void MODE(String channel, String modes, String params) {
    }
    
    /** 3.1.5 Mode Message
     * @param nick
     * @param modes
     */
    public void MODE(String nick, String modes) {
    }
    
    /** 3.4.9 Admin Command
     * @param target
     */
    public void ADMIN(String target) {
    }
    
    /** 4.2 Rehash message
     */
    public void REHASH() {
    }
    
    /** 3.6.2 Whois query
     * @param target
     * @param mask
     */
    public void WHOIS(String target, String[] mask) {
    }
    
    /** 3.2.5 Names message
     * @param channel
     * @param target
     */
    public void NAMES(String[] channel, String target) {
    }
    
    /** 3.6.3 Whowas
     * @param nick
     * @param count
     * @param target
     */
    public void WHOWAS(String[] nick, String count, String target) {
    }
    
    /** 3.3.1 Private messages
     * @param target
     * @param text
     * @throws MessageHandlerException
     */
    public void PRIVMSG(String target, String text) throws MessageHandlerException {
    }
    
    /** 4.4 Restart message
     */
    public void RESTART() {
    }
    
    /** 3.1.6 Service Message
     * @param nick
     * @param reserved_1
     * @param distribution
     * @param type
     * @param reserved_2
     * @param info
     */
    public void SERVICE(String nick, String reserved_1, String distribution, String type, String reserved_2, String info) {
    }
    
}
