/*
 * JoinMessage.java
 *
 */

package net.munki.irc.message;

import net.munki.irc.protocol.rfc2812.MessageNames;

public class JoinMessage implements CommandMessageInterface {

    private final String nick;
    private final String modifier;
    private final String user;
    private final String host;
    private final String channel;

    /** Creates new JoinMessage
     * @param nick
     * @param modifier
     * @param user
     * @param host
     * @param channel
     */
    public JoinMessage(String nick, String modifier, String user, String host, String channel) {
        this.nick = nick;
        this.modifier = modifier;
        this.user = user;
        this.host = host;
        this.channel = channel;
    }
    
    /**
     * @return
     */    
    public String getMessageType() {
        return MessageNames.JOIN;
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
    
}
