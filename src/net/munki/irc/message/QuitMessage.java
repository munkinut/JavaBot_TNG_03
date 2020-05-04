/*
 * QuitMessage.java
 *
 */

package net.munki.irc.message;

import net.munki.irc.protocol.rfc2812.MessageNames;

public class QuitMessage implements CommandMessageInterface {

    private final String nick;
    private final String modifier;
    private final String user;
    private final String host;
    private final String message;

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
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    /**
//     * @return
//     */
//    public String getNick() {
//        return this.nick;
//    }
// --Commented out by Inspection START (04/05/2020 21:37):
//// --Commented out by Inspection STOP (04/05/2020 21:37)
//
//// --Commented out by Inspection START (04/05/2020 21:37):
////    /**
////     * @return
// --Commented out by Inspection STOP (04/05/2020 21:37)
//     */
//    public String getModifier() {
//        return this.modifier;
//    }
// --Commented out by Inspection STOP (04/05/2020 21:37)

    /**
     * @return
     */    
    public String getUser() {
        return this.user;
    }
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    /**
//     * @return
//     */
// --Commented out by Inspection START (04/05/2020 21:37):
////    public String getHost() {
////        return this.host;
////    }
//// --Commented out by Inspection STOP (04/05/2020 21:37)
// --Commented out by Inspection STOP (04/05/2020 21:37)

    /**
     * @return
     */    
    public String getMessage() {
        return this.message;
    }
    
}
