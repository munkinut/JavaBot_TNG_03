/*
 * CommandEvent.java
 *
 * Generated in response to a client command action
 *
 * Created on 22 July 2002, 08:00
 */

package net.munki.irc.event;

/** An event representing an IRC Command
 */
public class IRCCommandEvent extends IRCEvent {

    /** Creates new CommandEvent
     * @param source The source of the event
     * @param actionCommand The action associated with the event, based on net.munki.irc.protocol.rfc2812.MessageNames
     */
    public IRCCommandEvent(Object source, Object actionCommand) {
        super(source, actionCommand);
    }

}
