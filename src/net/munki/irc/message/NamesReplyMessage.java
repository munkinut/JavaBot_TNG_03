/*
 * NamesReplyMessage.java
 *
 * Copyright (C) 2001 by Warren Milburn
 *
 */

package net.munki.irc.message;

import net.munki.irc.protocol.rfc2812.ReplyNames;

public class NamesReplyMessage implements ReplyMessageInterface {
    
    private String server;
    private String channelType;
    private String channel;
    private String[] names;

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
    
    /**
     * @return
     */    
    public String getChannel() {
        return this.channel;
    }
    
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
