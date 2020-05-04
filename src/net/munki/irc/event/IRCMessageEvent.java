/*
 * MessageEvent.java
 *
 * Generated in response to a non-numeric command message from the server
 *
 * Created on 22 July 2002, 07:59
 */

package net.munki.irc.event;

/** Represents an IRC message event.
 */
public class IRCMessageEvent extends IRCEvent {

    /** Creates a new MessageEvent.
     * @param source The source of the event
     * @param actionCommand An object representing the action command
     */
    public IRCMessageEvent(Object source, Object actionCommand) {
        super(source, actionCommand);
    }
}
