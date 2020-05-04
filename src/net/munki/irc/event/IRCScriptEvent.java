/*
 * IRCScriptEvent.java
 *
 * Created on 27 July 2002, 10:08
 */

package net.munki.irc.event;

/** An event representing a scripted command. */
public class IRCScriptEvent extends IRCEvent {

    /** Creates a new ScriptEvent.
     * @param source The source of the event
     * @param actionCommand An object representing the action command
     */
    public IRCScriptEvent(Object source, Object actionCommand) {
        super(source, actionCommand);
    }

}
