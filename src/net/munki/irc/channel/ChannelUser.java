/*
 * ChannelUser.java
 *
 * Created on 23 March 2002, 14:38
 */

package net.munki.irc.channel;

/** Represents a channel user
 */
public class ChannelUser {
    
    /** Channel user nickname
     */    
    private String nick;
    
    /** The modifier prepended to a nickname indicating the nature of
     * the connection.  E.g. "-" for a restricted connection or
     * "~" for an unverified ident.
     */    
    private final String modifier;
    /** Channel user ident
     */    
    private final String ident;
    /** Channel user host
     */    
    private final String host;
    /** Channel user flags
     */    
    private int flags;
    
    /** Creates a new ChannelUser object.
     * @param nick The nickname of the user.
     */    
    public ChannelUser(String nick) {
        this.nick = nick;
        this.modifier = "";
        this.ident = "";
        this.host = "";
        this.flags = Flags.NORMAL;
    }

    /** Creates a new ChannelUser object.
     * @param modifier The modifier, e.g. "~" for unverified or
     * "-" for restricted.
     * @param nick Channel user nickname
     * @param ident Channel user ident
     * @param host Channel user host
     */
    public ChannelUser(String nick, String modifier, String ident, String host) {
        this.nick = nick;
        this.modifier = modifier;
        this.ident = ident;
        this.host = host;
        this.flags = Flags.NORMAL;
    }
    
    /** Set the channel user nickname
     * @param nick Channel user nickname
     */    
    public void setNick(String nick) {
        this.nick = nick;
    }
    
    /** Get channel user nickname
     * @return Channel user nickname
     */    
    public String getNick() {
        return this.nick;
    }
    
    /** Returns the modifier.
     * @return The modifier.
     */    
    public String getModifier() {
        return this.modifier;
    }
    
    /** Get channel user ident
     * @return Channel user ident
     */    
    public String getIdent() {
        return this.ident;
    }
    
    /** Get channel user host
     * @return Channel user host
     */    
    public String getHost() {
        return this.host;
    }
    
    /** Set op flag
     */    
    public void op() {
        flags = flags | Flags.OP;
    }
    
    /** Set hop flag
     */    
    public void hop() {
        flags = flags | Flags.HOP;
    }
    
    /** Set voice flag
     */    
    public void voice() {
        flags = flags | Flags.VOICE;
    }
    
    /** Unset op flag
     */
    public void deop() {
        flags = flags & ~Flags.OP;
    }
    
    /** Unset hop flag */
    public void dehop() {
        flags = flags & ~Flags.HOP;
    }
    
    /** Unset voice flag */
    public void devoice() {
        flags = flags & ~Flags.VOICE;
    }
    
    /** Test for op
     * @return True if user has op flags, false if not
     */
    public boolean isOp() {
        return ((flags & Flags.OP) != 0x00);
    }
    
    /** Test for hop
     * @return True if user has hop flag, false if not
     */
    public boolean isHop() {
        return ((flags & Flags.HOP) != 0x00);
    }
    
    /** Test for voice
     * @return True if user has voice flag, false if not
     */
    public boolean isVoice() {
        return ((flags & Flags.VOICE) != 0x00);
    }
    
    /** Test for normal
     * @return True if user has normal flag
     */
    public boolean isNormal() {
        return ((flags & Flags.NORMAL) != 0x00);
    }
    
    /** Determines equality with another ChannelUser.
     * @param user The ChannelUser object to compare.
     * @return True if the ChannelUser is the same as this one.
     */    
    public boolean equals(ChannelUser user) {
        return ((this.getIdent().equals(user.getIdent())) &&
                (this.getHost().equals(user.getHost())));
    }
    
    
}
