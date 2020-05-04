/*
 * NicknameInUseMessage.java
 *
 * Created on 17 July 2002, 21:19
 */

package net.munki.irc.message;

import net.munki.irc.protocol.rfc2812.ReplyNames;

public class NicknameInUseMessage implements ReplyMessageInterface {

    private String server;
    private String nick;
    private String message;
    
    /** Creates new NicknameInUseMessage */
    public NicknameInUseMessage(String server, String nick, String message) {
        this.server = server;
        this.nick = nick;
        this.message = message;
    }

    /**
     * @return
     */    
    public String getMessageType() {
        return ReplyNames.ERR_NICKNAMEINUSE;
    }
    
    /**
     * @return
     */    
    public String getServer() {
        return server;
    }
    
    /**
     * @return
     */    
    public String getNick() {
        return nick;
    }
    
    /**
     * @return
     */    
    public String getMessage() {
        return message;
    }
    
}
