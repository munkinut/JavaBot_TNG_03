/*
 * IRCScriptListener.java
 *
 * Created on 27 July 2002, 10:11
 */

package net.munki.irc.event;

/** Listens for script events. */
public interface IRCScriptListener extends IRCListener {

    /** Dispatcher method responsible for handling IRC script events.
     * @param evt The IRC script event to handle
     */    
    public void dispatch(IRCScriptEvent evt);
}

