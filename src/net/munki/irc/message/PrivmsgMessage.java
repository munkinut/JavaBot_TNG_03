/*
 * PrivmsgMessage.java
 *
 */

package net.munki.irc.message;

import net.munki.irc.protocol.rfc2812.MessageNames;

public class PrivmsgMessage implements CommandMessageInterface {
    
    private final String nick;
    private final String modifier;
    private final String user;
    private final String host;
    private final String addressee;
    private final String message;

    /**
     * @param nick
     * @param modifier
     * @param user
     * @param host
     * @param addressee
     * @param message
     */    
    public PrivmsgMessage(String nick, String modifier, String user, String host, String addressee, String message) {
        this.nick = nick;
        this.modifier = modifier;
        this.user = user;
        this.host = host;
        this.addressee = addressee;
        this.message = message;
    }

    /**
     * @return
     */    
    public String getMessageType() {
        return MessageNames.PRIVMSG;
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
    public String getAddressee() {
        return this.addressee;
    }
    
    /**
     * @return
     */    
    public String getMessage() {
        return this.message;
    }
    
}
