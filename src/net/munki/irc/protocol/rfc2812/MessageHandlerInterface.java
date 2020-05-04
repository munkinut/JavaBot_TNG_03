/*
 * MessageHandlerInterface.java
 *
 * Created on 19 July 2002, 08:17
 */

package net.munki.irc.protocol.rfc2812;

public interface MessageHandlerInterface {

    // 3.1 Connection Registration
    
    /** 3.1.1 Password Message */
    void PASS(String pass) throws MessageHandlerException;
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    /** 3.1.2 Nick Message */
// --Commented out by Inspection START (04/05/2020 21:37):
////    void NICK(String nick) throws MessageHandlerException;
//// --Commented out by Inspection STOP (04/05/2020 21:37)
//
//    /** 3.1.3 User Message */
// --Commented out by Inspection STOP (04/05/2020 21:37)
    void USER(String user, String mode, String unused, String real) throws MessageHandlerException;
    
    /** 3.1.4 Oper Message */
    void OPER(String name, String pass) throws MessageHandlerException;
    
    /** 3.1.5 Mode Message */
    void MODE(String nick, String modes) throws MessageHandlerException;
    
    /** 3.1.6 Service Message */
    void SERVICE(String nick, String reserved_1, String distribution, String type, String reserved_2, String info) throws MessageHandlerException;
    
    /** 3.1.7 Quit */
    void QUIT(String message) throws MessageHandlerException;
    
    /** 3.1.8 SQuit */
    void SQUIT(String server, String comment) throws MessageHandlerException;
    

    // 3.2 Channel Operations
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    /** 3.2.1 Join message */
//    void JOIN(String[] channels) throws MessageHandlerException;
// --Commented out by Inspection STOP (04/05/2020 21:37)

    void JOIN(String[] channels, String[] keys) throws MessageHandlerException;
    
    /** 3.2.2 Part message */
    void PART(String[] channels, String message) throws MessageHandlerException;
    
    /** 3.2.3 Mode message */
    void MODE(String channel, String modes, String params) throws MessageHandlerException;
    
    /** 3.2.4 Topic message */
    void TOPIC(String channel, String topic) throws MessageHandlerException;
    
    /** 3.2.5 Names message */
    void NAMES(String[] channel, String target) throws MessageHandlerException;
    
    /** 3.2.6 List message */
    void LIST(String[] channels, String target) throws MessageHandlerException;
    
    /** 3.2.7 Invite message */
// --Commented out by Inspection START (04/05/2020 21:37):
//    void INVITE(String nickname, String channel) throws MessageHandlerException;
//
//    /** 3.2.8 Kick message */
//    void KICK(String[] channels, String[] nicks, String message) throws MessageHandlerException;
// --Commented out by Inspection STOP (04/05/2020 21:37)


    // 3.3 Sending messages

    /** 3.3.1 Private messages */
    void PRIVMSG(String target, String text) throws MessageHandlerException;
    
    /** 3.3.2 Notice */
    void NOTICE(String target, String text) throws MessageHandlerException;
    
    
    // 3.4 Server Queries and Commands

    /** 3.4.1 Motd message */
    void MOTD(String target) throws MessageHandlerException;
    
    /** 3.4.2 Lusers message */
    void LUSERS(String mask, String target) throws MessageHandlerException;
    
    /** 3.4.3 Version message */
    void VERSION(String target) throws MessageHandlerException;
    
    /** 3.4.4 Stats message */
    void STATS(String query, String target) throws MessageHandlerException;
    
    /** 3.4.5 Links message */
    void LINKS(String remote, String mask) throws MessageHandlerException;
    
    /** 3.4.6 Time message */
    void TIME(String target) throws MessageHandlerException;
    
    /** 3.4.7 Connect message */
    void CONNECT(String target, String port, String remote) throws MessageHandlerException;
    
    /** 3.4.8 Trace message */
    void TRACE(String target) throws MessageHandlerException;
    
    /** 3.4.9 Admin Command */
    void ADMIN(String target) throws MessageHandlerException;
    
    /** 3.4.10 Info Command */
    void INFO(String target) throws MessageHandlerException;
    

    // 3.5 Service Query and Commands

    /** 3.5.1 Servlist message */
    void SERVLIST(String mask, String type) throws MessageHandlerException;
    
    /** 3.5.2 Squery */
    void SQUERY(String service, String text) throws MessageHandlerException;
    
    
    // 3.6 User based Queries

    /** 3.6.1 Who query */
    void WHO(String mask, String operator) throws MessageHandlerException;
    
    /** 3.6.2 Whois query */
    void WHOIS(String target, String[] mask) throws MessageHandlerException;
    
    /** 3.6.3 Whowas */
    void WHOWAS(String[] nick, String count, String target) throws MessageHandlerException;
    
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    // 3.7 Miscellaneous messages
//
//    /** 3.7.1 Kill message */
//    void KILL(String nick, String comment) throws MessageHandlerException;
// --Commented out by Inspection STOP (04/05/2020 21:37)

    /** 3.7.2 Ping message */
    void PING(String server_1, String server_2) throws MessageHandlerException;
    
    /** 3.7.3 Pong message */
    void PONG(String server_1) throws MessageHandlerException;
    
    void PONG(String server_1, String server_2) throws MessageHandlerException;
    
    /** 3.7.4 Error */
    void ERROR(String message) throws MessageHandlerException;

    // 4 Optional Features
    
    /** 4.1 Away */
    void AWAY(String text) throws MessageHandlerException;

    /** 4.2 Rehash message */
    void REHASH() throws MessageHandlerException;

    /** 4.3 Die message */
    void DIE() throws MessageHandlerException;

    /** 4.4 Restart message */
    void RESTART() throws MessageHandlerException;

    /** 4.5 Summon message */
    void SUMMON(String user, String target, String channel) throws MessageHandlerException;

    /** 4.6 Users */
    void USERS(String target) throws MessageHandlerException;

    /** 4.7 Operwall message */
    void WALLOPS(String message) throws MessageHandlerException;

    /** 4.8 Userhost message */
    void USERHOST(String[] nicks) throws MessageHandlerException;

    /** 4.9 Ison message */
    void ISON(String[] nicks) throws MessageHandlerException;

}
    
