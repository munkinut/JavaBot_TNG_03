/*
 * NamesReplyMessage.java
 *
 * Copyright (C) 2001 by Warren Milburn
 *
 */

package net.munki.irc.message;

import net.munki.irc.protocol.rfc2812.ReplyNames;

public class NamesReplyMessage implements ReplyMessageInterface {
    
    private final String server;
    private final String channelType;
    private final String channel;
    private final String[] names;

    /**
     * @param server
     * @param channelType
     * @param channel
     * @param names
     */    
    public NamesReplyMessage(String server, String channelType, String channel, String[] names) {
        this.server = server;
        this.channelType = channelType;
        this.channel = channel;
        this.names = names;
    }

    /**
     * @return
     */    
    public String getMessageType() {
        return ReplyNames.RPL_NAMREPLY;
    }
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    /**
//     * @return
//     */
// --Commented out by Inspection START (04/05/2020 21:37):
////    public String getChannel() {
// --Commented out by Inspection START (04/05/2020 21:37):
//////        return this.channel;
//////    }
// --Commented out by Inspection START (04/05/2020 21:37):
//////// --Commented out by Inspection STOP (04/05/2020 21:37)
////// --Commented out by Inspection STOP (04/05/2020 21:37)
//// --Commented out by Inspection STOP (04/05/2020 21:37)
// --Commented out by Inspection STOP (04/05/2020 21:37)

    /**
     * @return
     */    
    public String getChannelType() {
        return this.channelType;
    }
    
    /**
     * @return
     */    
    public String[] getNames() {
        return this.names;
    }
    
    /**
     * @return
     */    
    public String getServer() {
        return this.server;
    }
    
}
