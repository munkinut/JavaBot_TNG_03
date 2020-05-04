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
    
    private String channel;
    private String user;
    private String host;
    private String server;
    private String nick;
    private String HG;
    private String asterisk;
    private String userStatus;
    private String hopCount;
    private String realName;
    
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

    public String getChannel() {
        return this.channel;
    }
    
    public String getUser() {
        return this.user;
    }
    
    public String getHost() {
        return this.host;
    }
    
    public String getNick() {
        return this.nick;
    }
    
    public String getHG() {
        return this.HG;
    }
    
    public String getServer() {
        return this.server;
    }
    
    public String getAsterisk() {
        return this.asterisk;
    }
    
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
