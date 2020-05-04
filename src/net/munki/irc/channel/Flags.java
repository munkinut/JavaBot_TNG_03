/*
 * Flags.java
 *
 * Created on 23 March 2002, 15:58
 */

package net.munki.irc.channel;

/** Represents channel user flags
 */
public class Flags {

    /** Normal flag
     */    
    public static final int NORMAL = 0x01;
    /** Voice flag
     */    
    public static final int  VOICE = 0x02;
    /** Half op flag
     */    
    public static final int    HOP = 0x04;
    /** Op flag
     */    
    public static final int     OP = 0x08;
    
    /** Prevents instantiation of this class as an object. */    
    private Flags() {
    }
    
}
