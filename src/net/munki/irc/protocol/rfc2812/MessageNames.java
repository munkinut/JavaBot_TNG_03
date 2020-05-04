/*
 * MessageNames.java
 *
 * Created on 20 July 2002, 10:46
 */

package net.munki.irc.protocol.rfc2812;

public class MessageNames {

    /** Prevents Instantiation */
    private MessageNames() {
    }

    // 3.1 Connection Registration
    
    public static final String PASS = "PASS";
    public static final String NICK = "NICK";
    public static final String USER = "USER";
    public static final String OPER = "OPER";
    public static final String USER_MODE = "MODE";
    public static final String SERVICE = "SERVICE";
    public static final String QUIT = "QUIT";
    public static final String SQUIT = "SQUIT";

    // 3.2 Channel Operations
    
    public static final String JOIN = "JOIN";
    public static final String PART = "PART";
    public static final String CHANNEL_MODE = "MODE";
    public static final String TOPIC = "TOPIC";
    public static final String NAMES = "NAMES";
    public static final String LIST = "LIST";
    public static final String INVITE = "INVITE";
    public static final String KICK = "KICK";

    // 3.3 Sending messages

    public static final String PRIVMSG = "PRIVMSG";
    public static final String NOTICE = "NOTICE";
    
    // 3.4 Server Queries and Commands

    public static final String MOTD = "MOTD";
    public static final String LUSERS = "LUSERS";
    public static final String VERSION = "VERSION";
    public static final String STATS = "STATS";
    public static final String LINKS = "LINKS";
    public static final String TIME = "TIME";
    public static final String CONNECT = "CONNECT";
    public static final String TRACE = "TRACE";
    public static final String ADMIN = "ADMIN";
    public static final String INFO = "INFO";

    // 3.5 Service Query and Commands

    public static final String SERVLIST = "SERVLIST";
    public static final String SQUERY = "SQUERY";
    
    // 3.6 User based Queries

    public static final String WHO = "WHO";
    public static final String WHOIS = "WHOIS";
    public static final String WHOWAS = "WHOWAS";
    
    // 3.7 Miscellaneous messages

    public static final String KILL = "KILL";
    public static final String PING = "PING";
    public static final String PONG = "PONG";
    public static final String ERROR = "ERROR";

    // 4 Optional Features
    
    public static final String AWAY = "AWAY";
    public static final String REHASH = "REHASH";
    public static final String DIE = "DIE";
    public static final String RESTART = "RESTART";
    public static final String SUMMON = "SUMMON";
    public static final String USERS = "USERS";
    public static final String WALLOPS = "WALLOPS";
    public static final String USERHOST = "USERHOST";
    public static final String ISON = "ISON";

}
