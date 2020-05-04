/*
 * IRCScriptAdapter.java
 *
 * Created on 27 July 2002, 12:48
 */

package net.munki.irc.handlers.script.beanshell;

import bsh.Interpreter;
import net.munki.irc.event.IRCScriptEvent;
import net.munki.irc.event.IRCScriptListener;

/** A convenience adapter providing empty implementations of script handler methods. */
public abstract class BeanshellScriptAdapter implements BeanshellScriptInterface, IRCScriptListener {

    /** The script interpreter. */    
    protected final Interpreter interpreter;

    /** Creates a new IRCScriptAdapter. */    
    public BeanshellScriptAdapter() {
        interpreter = new Interpreter();
    }
    /** Dispatcher method responsible for handling IRC script events.
     * @param evt The IRC script event to handle
     */
    public abstract void dispatch(IRCScriptEvent evt);
    
}
