/*
 * IRCMessageListener.java
 *
 * Created on 22 July 2002, 08:10
 */

package net.munki.irc.event;

import net.munki.irc.protocol.rfc2812.MessageHandlerException;

/** Interface describing the responsibilities of an IRC message listener.
 */
public interface IRCMessageListener extends IRCListener {

    /** Dispatcher method responsible for handling IRC message events.
     * @param evt The IRC message event to handle
     * @throws MessageHandlerException Thrown when message could not be dispatched.
     */    
    public void dispatch(IRCMessageEvent evt) throws MessageHandlerException;
}

