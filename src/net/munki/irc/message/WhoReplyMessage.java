/*
 * WhoReplyMessage.java
 *
 * Created on 16 October 2003, 08:16
 */

package net.munki.irc.message;

import net.munki.irc.protocol.rfc2812.ReplyNames;

/**
 *
 * @author  Warren Milburn
 */
public class WhoReplyMessage implements ReplyMessageInterface {
    
    private final String channel;
    private final String user;
    private final String host;
    private final String server;
    private final String nick;
    private final String HG;
    private final String asterisk;
    private final String userStatus;
    private final String hopCount;
    private final String realName;
    
    public WhoReplyMessage(String channel, String user, String host,
                           String server, String nick, String HG, String asterisk, String userStatus,
                           String hopCount, String realName) {
            this.channel = channel;
            this.user = user;
            this.host = host;
            this.server = server;
            this.nick = nick;
            this.HG = HG;
            this.asterisk = asterisk;
            this.userStatus = userStatus;
            this.hopCount = hopCount;
            this.realName = realName;
    }
    
    public String getMessageType() {
        return ReplyNames.RPL_WHOREPLY;
    }

// --Commented out by Inspection START (04/05/2020 21:37):
// --Commented out by Inspection START (04/05/2020 21:37):
////    public String getChannel() {
////        return this.channel;
////    }
//// --Commented out by Inspection START (04/05/2020 21:37):
// --Commented out by Inspection STOP (04/05/2020 21:37)
// --Commented out by Inspection START (04/05/2020 21:37):
////// --Commented out by Inspection STOP (04/05/2020 21:37)
////
// --Commented out by Inspection START (04/05/2020 21:37):
//// --Commented out by Inspection START (04/05/2020 21:37):
////////    public String getUser() {
////// --Commented out by Inspection STOP (04/05/2020 21:37)
// --Commented out by Inspection STOP (04/05/2020 21:37)
// --Commented out by Inspection STOP (04/05/2020 21:37)
// --Commented out by Inspection STOP (04/05/2020 21:37)
        return this.user;
    }
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    public String getHost() {
//        return this.host;
//    }
//
// --Commented out by Inspection START (04/05/2020 21:37):
////    public String getNick() {
//// --Commented out by Inspection STOP (04/05/2020 21:37)
// --Commented out by Inspection STOP (04/05/2020 21:37)
        return this.nick;
    }
    
    public String getHG() {
// --Commented out by Inspection START (04/05/2020 21:37):
//        return this.HG;
//    }
//
//    public String getServer() {
//        return this.server;
// --Commented out by Inspection STOP (04/05/2020 21:37)
    }
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    public String getAsterisk() {
//        return this.asterisk;
//    }
// --Commented out by Inspection STOP (04/05/2020 21:37)

    public String getUserStatus() {
        return this.userStatus;
    }
    
    public String getHopCount() {
        return this.hopCount;
    }
    
    public String getRealName() {
        return this.realName;
    }
    
}
