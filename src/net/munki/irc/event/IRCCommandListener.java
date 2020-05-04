/*
 * CommandListener.java
 *
 * Created on 22 July 2002, 08:04
 */

package net.munki.irc.event;

import net.munki.irc.protocol.rfc2812.MessageHandlerException;

/** Interface defining operations of a listener for IRCCommandEvents.
 */
public interface IRCCommandListener extends IRCListener {

    /** Dispatcher method for handling IRCCommandEvents.
     * @param evt The event to handle
     * @throws MessageHandlerException Thrown if an error occurs during dispatching
     */
    void dispatch(IRCCommandEvent evt) throws MessageHandlerException;
}

