/*
 * IRCMessageListener.java
 *
 * Created on 22 July 2002, 08:10
 */

package net.munki.irc.event;

import net.munki.irc.protocol.rfc2812.ReplyHandlerException;

/** Interface describing the responsibilities of an IRC message listener.
 */
public interface IRCReplyListener extends IRCListener {

    /** Dispatcher method responsible for handling IRC reply events.
     * @param evt The IRC reply event to handle
     * @throws ReplyHandlerException Thrown when a reply event could not be dispatched.
     */    
    public void dispatch(IRCReplyEvent evt) throws ReplyHandlerException;
}

