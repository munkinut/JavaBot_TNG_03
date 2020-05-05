/*
 * MessageHandlerAdapter.java
 *
 * Created on 20 July 2002, 13:58
 */

package net.munki.irc.protocol.rfc2812;

public abstract class MessageHandlerAdapter implements MessageHandlerInterface {

    /** Creates new MessageHandler */
    public MessageHandlerAdapter() {
    }

    /** 3.2.1 Join message  */
    public void JOIN(String[] channels) {
    }
    
    /** 3.5.2 Squery  */
    public void SQUERY(String service, String text) {
    }
    
    /** 3.4.8 Trace message  */
    public void TRACE(String target) {
    }
    
    /** 3.4.1 Motd message  */
    public void MOTD(String target) {
    }
    
    /** 3.4.3 Version message  */
    public void VERSION(String target) {
    }
    
    /** 3.6.3 Whowas  */
    public void WHOWAS(String[] nick, String count, String target) {
    }
    
    /** 3.1.6 Service Message  */
    public void SERVICE(String nick, String reserved_1, String distribution, String type, String reserved_2, String info) {
    }
    
    /** 3.7.2 Ping message  */
    public void PING(String server_1, String server_2) {
    }
    
    /** 3.1.5 Mode Message  */
    public void MODE(String nick, String modes) {
    }
    
    /** 3.2.3 Mode message  */
    public void MODE(String channel, String modes, String params) {
    }
    
    /** 3.3.1 Private messages  */
    public void PRIVMSG(String target, String text) {
    }
    
    public void JOIN(String[] channels, String[] keys) {
    }
    
    /** 3.1.8 SQuit  */
    public void SQUIT(String server, String comment) {
    }
    
    /** 3.6.1 Who query  */
    public void WHO(String mask, String operator) {
    }
    
    /** 3.4.4 Stats message  */
    public void STATS(String query, String target) {
    }
    
    /** 3.1.7 Quit  */
    public void QUIT(String message) {
    }
    
    /** 3.2.5 Names message  */
    public void NAMES(String[] channel, String target) {
    }
    
    /** 3.2.7 Invite message  */
    public void INVITE(String nickname, String channel) {
    }
    
    /** 3.7.1 Kill message  */
    public void KILL(String nick, String comment) {
    }
    
    /** 3.2.4 Topic message  */
    public void TOPIC(String channel, String topic) {
    }
    
    /** 3.4.2 Lusers message  */
    public void LUSERS(String mask, String target) {
    }
    
    /** 3.4.5 Links message  */
    public void LINKS(String remote, String mask) {
    }
    
    /** 3.1.2 Nick Message  */
    public void NICK(String nick) {
    }
    
    /** 3.1.1 Password Message  */
    public void PASS(String pass) {
    }
    
    /** 3.4.7 Connect message  */
    public void CONNECT(String target, String port, String remote) {
    }
    
    /** 3.1.3 User Message  */
    public void USER(String user, String mode, String unused, String real) {
    }
    
    /** 3.1.4 Oper Message  */
    public void OPER(String name, String pass) {
    }
    
    /** 3.2.6 List message  */
    public void LIST(String[] channels, String target) {
    }
    
    /** 3.3.2 Notice  */
    public void NOTICE(String target, String text) {
    }
    
    public void PONG(String server_1, String server_2) {
    }
    
    /** 3.2.8 Kick message  */
    public void KICK(String[] channels, String[] nicks, String message) {
    }
    
    /** 3.7.4 Error  */
    public void ERROR(String message) {
    }
    
    /** 3.7.3 Pong message  */
    public void PONG(String server_1) {
    }
    
    /** 3.4.10 Info Command  */
    public void INFO(String target) {
    }
    
    /** 3.4.9 Admin Command  */
    public void ADMIN(String target) {
    }
    
    /** 3.5.1 Servlist message  */
    public void SERVLIST(String mask, String type) {
    }
    
    /** 3.2.2 Part message  */
    public void PART(String[] channels, String message) {
    }
    
    /** 3.6.2 Whois query  */
    public void WHOIS(String target, String[] mask) {
    }
    
    /** 3.4.6 Time message  */
    public void TIME(String target) {
    }
    
    /** 4.3 Die message  */
    public void DIE() {
    }
    
    /** 4.9 Ison message  */
    public void ISON(String[] nicks) {
    }
    
    /** 4.5 Summon message  */
    public void SUMMON(String user, String target, String channel) {
    }
    
    /** 4.7 Operwall message  */
    public void WALLOPS(String message) {
    }
    
    /** 4.8 Userhost message  */
    public void USERHOST(String[] nicks) {
    }
    
    /** 4.1 Away  */
    public void AWAY(String text) {
    }
    
    /** 4.6 Users  */
    public void USERS(String target) {
    }
    
    /** 4.2 Rehash message  */
    public void REHASH() {
    }
    
    /** 4.4 Restart message  */
    public void RESTART() {
    }
    
}
