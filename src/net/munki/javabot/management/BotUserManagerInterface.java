/*
 * ChannelManagerInterface.java
 *
 * Created on 30 September 2003, 14:24
 */

package net.munki.javabot.management;

import net.munki.irc.channel.Channel;
import net.munki.irc.channel.ChannelUser;

/** Interface for all Bot User Managers.  You may decide to implement the
 * user file configuration using XML or Properties for example.
 */
public interface BotUserManagerInterface {
    
    /** Determines whether or not the given user is allowed to op.
     * @param channelUser The user trying to op someone through the bot.
     * @param channel The channel on which the op has been requested.
     * @return True if op is allowed, otherwise false.
     */    
    public boolean canOp(ChannelUser channelUser, Channel channel);
    
    /** Determines whether or not the given user is allowed to deop.
     * @param channelUser The user trying to deop someone through the bot.
     * @param channel The channel on which the deop has been requested.
     * @return True if deop is allowed, otherwise false.
     */    
    public boolean canDeop(ChannelUser channelUser, Channel channel);
    
    /** Determines whether or not the given user is allowed to voice.
     * @param channelUser The user trying to voice someone through the bot.
     * @param channel The channel on which the voice has been requested.
     * @return True if voice is allowed, otherwise false.
     */    
    public boolean canVoice(ChannelUser channelUser, Channel channel);
    
    /** Determines whether or not the given user is allowed to devoice.
     * @param channelUser The user trying to devoice someone through the bot.
     * @param channel The channel on which the devoice has been requested.
     * @return True if devoice is allowed, otherwise false.
     */    
    public boolean canDevoice(ChannelUser channelUser, Channel channel);

}
