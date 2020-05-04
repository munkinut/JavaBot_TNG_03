/*
 * JaclScriptAdapter.java
 *
 * Created on 07 October 2003, 01:41
 */

package net.munki.irc.handlers.script.jacl;

import net.munki.irc.event.IRCScriptEvent;
import net.munki.irc.event.IRCScriptListener;
import tcl.lang.*;

/** A convenience adapter providing empty implementations of script handler methods. */
public abstract class JaclScriptAdapter implements JaclScriptInterface, IRCScriptListener {

    /** The script interpreter. */    
    protected Interp interpreter;

    /** Creates a new JaclScriptAdapter. */    
    public JaclScriptAdapter() {
        interpreter = new Interp();
    }
    /** Dispatcher method responsible for handling IRC script events.
     * @param evt The IRC script event to handle
     */
    public abstract void dispatch(IRCScriptEvent evt);
    
}
