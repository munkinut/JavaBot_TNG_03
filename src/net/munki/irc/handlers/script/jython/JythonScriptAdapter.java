/*
 * JythonScriptAdapter.java
 *
 * Created on 02 October 2003, 23:29
 */

package net.munki.irc.handlers.script.jython;

import net.munki.irc.event.IRCScriptEvent;
import net.munki.irc.event.IRCScriptListener;
import org.python.util.PythonInterpreter;

/** A convenience adapter providing empty implementations of script handler methods. */
public abstract class JythonScriptAdapter implements JythonScriptInterface, IRCScriptListener {

    /** The script interpreter. */    
    protected PythonInterpreter interpreter;

    /** Creates a new IRCScriptAdapter. */    
    public JythonScriptAdapter() {
        interpreter = new PythonInterpreter();
    }
    /** Dispatcher method responsible for handling IRC script events.
     * @param evt The IRC script event to handle
     */
    public abstract void dispatch(IRCScriptEvent evt);
    
}
