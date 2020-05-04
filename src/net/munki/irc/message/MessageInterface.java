/*
 * MessageInterface.java - defines all methods for an irc message object
 *
 */

package net.munki.irc.message;

public interface MessageInterface {
    
    /**
     * @return
     */    
    public String getMessageType();
    /**
     * @return
     */    
    public String getNick();
    /**
     * @return
     */    
    public String getHostmask();
    /**
     * @return
     */    
    public String getChannel();
    /**
     * @return
     */    
    public String getCmd();
    /**
     * @return
     */    
    public String getParams();
    /**
     * @return
     */    
    public String getMsgTo();
    /**
     * @return
     */    
    public String getChannelType();
    /**
     * @return
     */    
    public String getServer();
    /**
     * @return
     */    
    public String getNames();

    /**
     * @param nick
     */    
    public void setNick(String nick);
    /**
     * @param hostmask
     */    
    public void setHostmask(String hostmask);
    /**
     * @param channel
     */    
    public void setChannel(String channel);
    /**
     * @param cmd
     */    
    public void setCmd(String cmd);
    /**
     * @param params
     */    
    public void setParams(String params);
    /**
     * @param msgTo
     */    
    public void setMsgTo(String msgTo);
    /**
     * @param channelType
     */    
    public void setChannelType(String channelType);
    /**
     * @param server
     */    
    public void setServer(String server);
    /**
     * @param names
     */    
    public void setNames(String names);
}

