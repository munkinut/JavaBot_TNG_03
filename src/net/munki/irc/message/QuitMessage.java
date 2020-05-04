/*
 * QuitMessage.java
 *
 */

package net.munki.irc.message;

import net.munki.irc.protocol.rfc2812.MessageNames;

public class QuitMessage implements CommandMessageInterface {

    private String nick;
    private String modifier;
    private String user;
    private String host;
    private String message;

    /**
     * @param nick
     * @param modifier
     * @param user
     * @param host
     * @param message
     */    
    public QuitMessage(String nick, String modifier, String user, String host, String message) {
        this.nick = nick;
        this.modifier = modifier;
        this.user = user;
        this.host = host;
        this.message = message;
    }

    /**
     * @return
     */    
    public String getMessageType() {
        return MessageNames.QUIT;
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
    public String getMessage() {
        return this.message;
    }
    
}
