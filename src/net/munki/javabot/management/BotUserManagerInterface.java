/*
 * ChannelManagerInterface.java
 *
 * Created on 30 September 2003, 14:24
 */

package net.munki.javabot.management;

import net.munki.irc.channel.ChannelUser;

/** Interface for all Bot User Managers.  You may decide to implement the
 * user file configuration using XML or Properties for example.
 */
public interface BotUserManagerInterface {
    
    /** Determines whether or not the given user is allowed to op.
     * @param channelUser The user trying to op someone through the bot.
     * @return True if op is allowed, otherwise false.
     */
    boolean canOp(ChannelUser channelUser);
    
    /** Determines whether or not the given user is allowed to deop.
     * @param channelUser The user trying to deop someone through the bot.
     * @return True if deop is allowed, otherwise false.
     */
    boolean canDeop(ChannelUser channelUser);
    
    /** Determines whether or not the given user is allowed to voice.
     * @param channelUser The user trying to voice someone through the bot.
     * @return True if voice is allowed, otherwise false.
     */
    boolean canVoice(ChannelUser channelUser);
    
    /** Determines whether or not the given user is allowed to devoice.
     * @param channelUser The user trying to devoice someone through the bot.
     * @return True if devoice is allowed, otherwise false.
     */
    boolean canDevoice(ChannelUser channelUser);

}
