/*
 * MessageInterface.java - deinfos all methods for an irc message object
 *
 */

package net.munki.irc.message;

public interface MessageInterface {
    
    /**
     * @return
     */
    String getMessageType();
    /**
     * @return
     */
    String getNick();
    /**
     * @return
     */
    String getHostmask();
    /**
     * @return
     */
    String getChannel();
    /**
     * @return
     */
    String getCmd();
    /**
     * @return
     */
    String getParams();
    /**
     * @return
     */
    String getMsgTo();
    /**
     * @return
     */
    String getChannelType();
    /**
     * @return
     */
    String getServer();
    /**
     * @return
     */
    String getNames();

    /**
     * @param nick
     */
    void setNick(String nick);
    /**
     * @param hostmask
     */
    void setHostmask(String hostmask);
    /**
     * @param channel
     */
    void setChannel(String channel);
    /**
     * @param cmd
     */
    void setCmd(String cmd);
    /**
     * @param params
     */
    void setParams(String params);
    /**
     * @param msgTo
     */
    void setMsgTo(String msgTo);
    /**
     * @param channelType
     */
    void setChannelType(String channelType);
    /**
     * @param server
     */
    void setServer(String server);
    /**
     * @param names
     */
    void setNames(String names);
}

