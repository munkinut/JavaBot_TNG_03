/*
 * IRCEvent.java
 *
 * Created on 22 July 2002, 07:59
 */

package net.munki.irc.event;

import java.util.ArrayList;

/** An abstract representation of an IRC event.
 */
public abstract class IRCEvent {
    
    /** The source of an event. */    
    private final Object source;
    /** The action command associated with this event. */    
    private final Object actionCommand;
    /** The list of parameters to this event. */    
    private final ArrayList<String> parameters;

    /** Creates new Event.
     * @param source The source of the event
     * @param actionCommand An object representing the event to handle
     */
    public IRCEvent(Object source, Object actionCommand) {
        this.source = source;
        this.actionCommand = actionCommand;
        this.parameters = new ArrayList<>();
    }
    
    /** Get the source of the event.
     * @return The source of the event
     */    
    public Object getSource() {
        return source;
    }
    
    /** Get the action command object.
     * @return An object representing the action command
     */    
    public Object getActionCommand() {
        return actionCommand;
    }
    
    /** Add a parameter to the event.
     * @param parameter Parameter to add
     */    
    public void addParameter(String parameter) {
        parameters.add(parameter);
    }

    /** Get a list of parameters.
     * @return A list of parameters
     */    
    public ArrayList<String> getParameters() {
        return parameters;
    }
}
