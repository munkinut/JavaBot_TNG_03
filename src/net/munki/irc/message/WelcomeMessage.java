/*
 * WelcomeMessage.java
 *
 * Created on 17 July 2002, 21:19
 */

package net.munki.irc.message;

import net.munki.irc.protocol.rfc2812.ReplyNames;

public class WelcomeMessage implements ReplyMessageInterface {

    private final String message;
    private final String mask;
    
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
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    /**
//     * @return
//     */
//    public String getMask() {
//        return mask;
//    }
// --Commented out by Inspection STOP (04/05/2020 21:37)

}
