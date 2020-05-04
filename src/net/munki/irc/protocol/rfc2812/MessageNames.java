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
    
    // --Commented out by Inspection (04/05/2020 21:37):public static final String PASS = "PASS";
    public static final String NICK = "NICK";
// --Commented out by Inspection START (04/05/2020 21:37):
//    public static final String USER = "USER";
//// --Commented out by Inspection START (04/05/2020 21:37):
// --Commented out by Inspection STOP (04/05/2020 21:37)
//    // --Commented out by Inspection (04/05/2020 // --Commented out by Inspection (04/05/2020 21:37):21:37):public static final String OPER = "OPER";
//    public static final String USER_MODE = "MODE";
// --Commented out by Inspection STOP (04/05/2020 21:37)
    public static final String SERVICE = "SERVICE";
// --Commented out by Inspection START (04/05/2020 21:37):
//    public static final String QUIT = "QUIT";
//    public static final String SQUIT = "SQUIT";
// --Commented out by Inspection STOP (04/05/2020 21:37)

    // 3.2 Channel Operations
    
    public static final String JOIN = "JOIN";
    public static final String PART = "PART";
// --Commented out by Inspection START (04/05/2020 21:37):
//    public static final String CHANNEL_MODE = "MODE";
//    public static final String TOPIC = "TOPIC";
// --Commented out by Inspection STOP (04/05/2020 21:37)
    // --Commented out by Inspection (04/05/2020 21:37):public static final String NAMES = "NAMES";
    // --Commented out by Inspection (04/05/2020 21:37):public static final String LIST = "LIST";
// --Commented out by Inspection START (04/05/2020 21:37):
// --Commented out by Inspection START (04/05/2020 21:37):
////// --Commented out by Inspection START (04/05/2020 21:37):
//////    // --Comme// --Commented out by Inspection (04/05/2020// --Commented out by Inspection (04/05/2020 21:// --Commented out by Inspection (04/05/2020 21:37):37): 21:37):nte// --Commented out by Inspection (04/05/2020 21:37):d out by Inspection (04/05/2020 21:37):public static final String INVITE = "INVITE";
// --Commented out by Inspection STOP (04/05/2020 21:37)
// --Commented out by Inspection STOP (04/05/2020 21:37)
//    public static final String KICK = "KICK";
// --Commented out by Inspection STOP (04/05/2020 21:37)

    // 3.3 Sending messages

// --Commented out by Inspection START (04/05/2020 21:37):
//    public static final String PRIVMSG = "PRIVMSG";
//// --Commented out by Inspection START (04/05/2020 21:37):
// --Commented out by Inspection STOP (04/05/2020 21:37)
// --Commented out by Inspection START (04/05/2020 21:37):
// --Comment// --Commented out by Inspection (04/05/2020 21:37):ed out by Inspection START (04/05/2020 21:37):
//////   // --Commented out by Inspection (04/05/2020 21:37): public static final String NOTICE = "NOTICE";
//////
//////    // 3.4 Server Queries and Commands
// --Commented out by Inspection STOP (04/05/2020 21:37)
// --Commented out by Inspection START (04/05/2020 21:37):
//// --Commented out by Inspection STOP (04/05/2020 21:37)
//// --Commented out by Inspection STOP (04/05/2020 21:37)
// --Commented out by Inspection STOP (04/05/2020 21:37)

    public static final String MOTD = "MOTD";
    public static final String LUSERS = "LUSERS";
    public static final String VERSION = "VERSION";
// --Commented out by Ins// --Commented out by Inspection (04/05/2020 21:37):pection (04/05/2020 21:37):    public static final String STATS = "STATS";
    public static final String LINKS = "LINKS";
    public static final String TIME = "TIME";
    // --Commented out by Inspection (04/05/2020 21:37):public static final String CONNECT = "CONNECT";
// --Commented out by Inspection START (04/05/2020 21:37):
//    public static final String TRACE = "TRACE";
//// --Commented out by Inspecti// --Commented out by Inspection (04/05/2020 21:37):on (04/05/2020 21:37):    // --Commented out by Inspection (04/05/2020 21:37):public static final String ADMIN = "ADMIN";
// --Commented out by Inspection STOP (04/05/2020 21:37)
    public static final String INFO = "INFO";

    // 3.5 Service Query and Commands

    public static final String SERVLIST = "SERVLIST";
    public static final String SQUERY = "SQUERY";
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    // 3.6 User based Queries
//
//    public static final String WHO = "WHO";
// --Commented out by Inspection STOP (04/05/2020 21:37)
    public static final String WHOIS = "WHOIS";
    public static final String WHOWAS = "WHOWAS";
    
    // 3.7 Miscellaneous messages

// --Commented out by Inspection START (04/05/2020 21:37):
//    public static final String KILL = "KILL";
//    public static final String PING = "PING";
// --Commented out by Inspection STOP (04/05/2020 21:37)
    public static final String PONG = "PONG";
// --Commented out by Inspection START (04/05/2020 21:37):
// --Commented out by Inspection START (04/05/2020 21:37):
// --Commented out by Inspection START (04/05/2020 21:37):
//////    public static final String ERROR = "ERROR";
//////
//////    // 4 Optional Features
// --Commented out by Inspection STOP (04/05/2020 21:37)
// --Commented out by Inspection STOP (04/05/2020 21:37)
// --Commented out by Inspection STOP (04/05/2020 21:37)

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
