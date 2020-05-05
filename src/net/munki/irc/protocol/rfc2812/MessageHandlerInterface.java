/*
 * MessageHandlerInterface.java
 *
 * Created on 19 July 2002, 08:17
 */

package net.munki.irc.protocol.rfc2812;

public interface MessageHandlerInterface {

    // 3.1 Connection Registration
    
    /** 3.1.1 Password Message */
    void PASS(String pass);
    
    /** 3.1.2 Nick Message */
    void NICK(String nick) throws MessageHandlerException;
    
    /** 3.1.3 User Message */
    void USER(String user, String mode, String unused, String real) throws MessageHandlerException;
    
    /** 3.1.4 Oper Message */
    void OPER(String name, String pass);
    
    /** 3.1.5 Mode Message */
    void MODE(String nick, String modes);
    
    /** 3.1.6 Service Message */
    void SERVICE(String nick, String reserved_1, String distribution, String type, String reserved_2, String info);
    
    /** 3.1.7 Quit */
    void QUIT(String message);
    
    /** 3.1.8 SQuit */
    void SQUIT(String server, String comment);
    

    // 3.2 Channel Operations
    
    /** 3.2.1 Join message */
    void JOIN(String[] channels) throws MessageHandlerException;

    void JOIN(String[] channels, String[] keys);
    
    /** 3.2.2 Part message */
    void PART(String[] channels, String message);
    
    /** 3.2.3 Mode message */
    void MODE(String channel, String modes, String params) throws MessageHandlerException;
    
    /** 3.2.4 Topic message */
    void TOPIC(String channel, String topic);
    
    /** 3.2.5 Names message */
    void NAMES(String[] channel, String target);
    
    /** 3.2.6 List message */
    void LIST(String[] channels, String target);
    
    /** 3.2.7 Invite message */
    void INVITE(String nickname, String channel);
    
    /** 3.2.8 Kick message */
    void KICK(String[] channels, String[] nicks, String message);
    

    // 3.3 Sending messages

    /** 3.3.1 Private messages */
    void PRIVMSG(String target, String text) throws MessageHandlerException;
    
    /** 3.3.2 Notice */
    void NOTICE(String target, String text);
    
    
    // 3.4 Server Queries and Commands

    /** 3.4.1 Motd message */
    void MOTD(String target);
    
    /** 3.4.2 Lusers message */
    void LUSERS(String mask, String target);
    
    /** 3.4.3 Version message */
    void VERSION(String target);
    
    /** 3.4.4 Stats message */
    void STATS(String query, String target);
    
    /** 3.4.5 Links message */
    void LINKS(String remote, String mask);
    
    /** 3.4.6 Time message */
    void TIME(String target);
    
    /** 3.4.7 Connect message */
    void CONNECT(String target, String port, String remote);
    
    /** 3.4.8 Trace message */
    void TRACE(String target);
    
    /** 3.4.9 Admin Command */
    void ADMIN(String target);
    
    /** 3.4.10 Info Command */
    void INFO(String target);
    

    // 3.5 Service Query and Commands

    /** 3.5.1 Servlist message */
    void SERVLIST(String mask, String type);
    
    /** 3.5.2 Squery */
    void SQUERY(String service, String text);
    
    
    // 3.6 User based Queries

    /** 3.6.1 Who query */
    void WHO(String mask, String operator) throws MessageHandlerException;
    
    /** 3.6.2 Whois query */
    void WHOIS(String target, String[] mask);
    
    /** 3.6.3 Whowas */
    void WHOWAS(String[] nick, String count, String target);
    
    
    // 3.7 Miscellaneous messages

    /** 3.7.1 Kill message */
    void KILL(String nick, String comment);
    
    /** 3.7.2 Ping message */
    void PING(String server_1, String server_2);
    
    /** 3.7.3 Pong message */
    void PONG(String server_1) throws MessageHandlerException;
    
    void PONG(String server_1, String server_2);
    
    /** 3.7.4 Error */
    void ERROR(String message);

    // 4 Optional Features
    
    /** 4.1 Away */
    void AWAY(String text);

    /** 4.2 Rehash message */
    void REHASH();

    /** 4.3 Die message */
    void DIE();

    /** 4.4 Restart message */
    void RESTART();

    /** 4.5 Summon message */
    void SUMMON(String user, String target, String channel);

    /** 4.6 Users */
    void USERS(String target);

    /** 4.7 Operwall message */
    void WALLOPS(String message);

    /** 4.8 Userhost message */
    void USERHOST(String[] nicks);

    /** 4.9 Ison message */
    void ISON(String[] nicks);

}
    
