/*
 * KickMessage.java
 *
 */

package net.munki.irc.message;

import net.munki.irc.protocol.rfc2812.MessageNames;

public class KickMessage implements CommandMessageInterface {

    private String nick;
    private String modifier;
    private String user;
    private String host;
    private String channel;
    private String kicked;

    /** Creates new KickMessage
     * @param nick
     * @param modifier
     * @param user
     * @param host
     * @param channel
     * @param kicked
     */
    public KickMessage(String nick, String modifier, String user, String host, String channel, String kicked) {
        this.nick = nick;
        this.modifier = modifier;
        this.user = user;
        this.host = host;
        this.channel = channel;
        this.kicked = kicked;
    }
    
    /**
     * @return
     */    
    public String getMessageType() {
        return MessageNames.KICK;
    }
    
    /**
     * @return
     */    
    public String getNick() {
        return this.nick;
    }
    
    /**
     * @return
     */    
    public String getModifier() {
        return this.modifier;
    }
    
    /**
     * @return
     */    
    public String getUser() {
        return this.user;
    }
    
    /**
     * @return
     */    
    public String getHost() {
        return this.host;
    }
    
    /**
     * @return
     */    
    public String getChannel() {
        return this.channel;
    }
    
    /**
     * @return
     */    
    public String getKicked() {
        return this.kicked;
    }
    
}
