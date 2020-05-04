/*
 * WelcomeMessage.java
 *
 * Created on 17 July 2002, 21:19
 */

package net.munki.irc.message;

import net.munki.irc.protocol.rfc2812.ReplyNames;

public class WelcomeMessage implements ReplyMessageInterface {

    private String message;
    private String mask;
    
    /** Creates new NicknameInUseMessage
     * @param message
     * @param mask
     */
    public WelcomeMessage(String message, String mask) {
        this.message = message;
        this.mask = mask;
    }

    /**
     * @return
     */    
    public String getMessageType() {
        return ReplyNames.RPL_WELCOME;
    }
    
    /**
     * @return
     */    
    public String getMessage() {
        return message;
    }
    
    /**
     * @return
     */    
    public String getMask() {
        return mask;
    }
    
}
