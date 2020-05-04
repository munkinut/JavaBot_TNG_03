/*
 * Channel.java
 *
 * Created on 23 March 2002, 14:20
 */

package net.munki.irc.channel;

import java.util.List;

/** Represents an IRC channel
 */
public class Channel {
    
    /** Channel name
     */    
    private final String name;
    /** Channel topic
     */    
    private String topic;
    /** Channel modes
     */    
    private String modes;
    /** Channel users
     */    
    private final List users;
    /** Channel joined flag
     */
    private boolean joined;

    /** Creates new Channel
     * @param name Channel name
     * @param topic Channel topic
     * @param modes Channel modes
     * @param users Channel users
     */
    public Channel(String name, String topic, String modes, List users) {
        this.name = name;
        this.topic = topic;
        this.modes = modes;
        this.users = users;
        this.joined = false;
    }
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    /** Set channel topic
//     * @param topic Channel topic
//     */
//    public void setTopic(String topic) {
//        this.topic = topic;
//    }
// --Commented out by Inspection STOP (04/05/2020 21:37)

// --Commented out by Inspection START (04/05/2020 21:37):
//    /** Set channel modes
//     * @param modes Channel modes
//     */
//    public void setModes(String modes) {
//        this.modes = modes;
//    }
// --Commented out by Inspection STOP (04/05/2020 21:37)

// --Commented out by Inspection START (04/05/2020 21:37):
//    /** Sets a flag to determine whether or not a channel has been joined.
//     * @param joined True if channel has been joined, false if not
//     */
//   public void setJoined(boolean joined) {
//       this.joined = joined;
//   }
// --Commented out by Inspection STOP (04/05/2020 21:37)

// --Commented out by Inspection START (04/05/2020 21:37):
//   /** Determines if the channel has been joined.
//    * @return True if the channel has been joined, false if not
//    */
//   public boolean isJoined() {
//       return this.joined;
//   }
// --Commented out by Inspection STOP (04/05/2020 21:37)

// --Commented out by Inspection START (04/05/2020 21:37):
// --Commented out by Inspection START (04/05/2020 21:37):
////    /** Add user to channel
////     * @param user Channel user
////     * @return Success
////     */
////    public boolean addUser(ChannelUser user) {
////        return users.add(user);
////    }
// --Commented out by Inspection STOP (04/05/2020 21:37)
// --Commented out by Inspection STOP (04/05/2020 21:37)

    /** Remove user from channel
     * @param user Channel user
     * @return Success
     */    
    public boolean removeUser(ChannelUser user) {
        return users.remove(user);
    }
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    /** Get channel name
//     * @return Channel name
//     */
//    public String getName() {
//        return this.name;
//    }
//
// --Commented out by Inspection STOP (04/05/2020 21:37)
// --Commented out by Inspection START (04/05/2020 21:37):
//// --Commented out by Inspection START (04/05/2020 21:37):
////    /** Get channel topic
////     * @return Channel topic
////     */
////    public String getTopic() {
// --Commented out by Inspection STOP (04/05/2020 21:37)
//        return this.topic;
//    }
//
// --Commented out by Inspection STOP (04/05/2020 21:37)
    /** Get channel modes
     * @return Channel modes
     */    
    public String getModes() {
        return this.modes;
    }
    
    /** Get channel users
     * @return Channel users
     */    
    public List getUsers() {
        return this.users;
    }
    
// --Commented out by Inspection START (04/05/2020 21:37):
//    /** Returns the name of the channel
//     * @return Channel name
//     */
//    public String toString() {
//        return this.name;
//    }
//
//    /** Determines equality with another channel object.
//     * @param channel Channel with which to compare equality
//     * @return True if equal, false if not
// --Commented out by Inspection STOP (04/05/2020 21:37)
     */
    public boolean equals(Channel channel) {
        return (channel.getName().equals(this.getName()));
    }

}
