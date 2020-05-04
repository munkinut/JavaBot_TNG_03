/*
 * NicknameInUseMessage.java
 *
 * Created on 17 July 2002, 21:19
 */

package net.munki.irc.message;

import net.munki.irc.protocol.rfc2812.ReplyNames;

public class NicknameInUseMessage implements ReplyMessageInterface {

    private final String server;
    private final String nick;
    private final String message;
    
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
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    /**
//     * @return
//     */
//    public String getServer() {
//        return server;
//    }
// --Commented out by Inspection STOP (04/05/2020 21:37)

// --Commented out by Inspection START (04/05/2020 21:37):
//    /**
//     * @return
//     */
//    public String getNick() {
//        return nick;
//    }
// --Commented out by Inspection STOP (04/05/2020 21:37)

    /**
     * @return
     */    
    public String getMessage() {
        return message;
    }
    
}
