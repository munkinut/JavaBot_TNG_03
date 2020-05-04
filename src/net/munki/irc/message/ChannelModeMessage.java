/*
 * ChannelModeMessage.java
 *
 * Created on 01 August 2002, 19:39
 */

package net.munki.irc.message;

import net.munki.irc.protocol.rfc2812.MessageNames;

public class ChannelModeMessage implements CommandMessageInterface {
    
    private final String nick;
    private final String modifier;
    private final String user;
    private final String host;
    private final String channel;
    private final String modes;
    private final String params;

    /** Creates new ChannelModeMessage
     * @param from
     * @param modifier
     * @param user
     * @param host
     * @param channel
     * @param modes
     * @param params
     */
    public ChannelModeMessage(String from, String modifier, String user, String host, String channel, String modes, String params) {
        this.nick = from;
        this.modifier = modifier;
        this.user = user;
        this.host = host;
        this.channel = channel;
        this.modes = modes;
        this.params = params;
    }

    /**
     * @return
     */    
    public String getMessageType() {
        return MessageNames.CHANNEL_MODE;
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
    public String getModes() {
        return this.modes;
    }
    
    /**
     * @return
     */    
    public String getParams() {
        return this.params;
    }
    
}
