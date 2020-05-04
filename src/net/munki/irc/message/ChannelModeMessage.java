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
// --Commented out by Inspection START (04/05/2020 21:37):
////    /**
////     * @return
////     */
////    public String getHost() {
////        return this.host;
// --Commented out by Inspection STOP (04/05/2020 21:37)
//    }
// --Commented out by Inspection START (04/05/2020 21:37):
//// --Commented out by Inspection STOP (04/05/2020 21:37)
//
//// --Commented out by Inspection START (04/05/2020 21:37):
////    /**
////     * @return
// --Commented out by Inspection STOP (04/05/2020 21:37)
//     */
//    public String getChannel() {
//        return this.channel;
//    }
// --Commented out by Inspection STOP (04/05/2020 21:37)

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
