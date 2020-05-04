/*
 * CommandHandlerException.java
 *
 * Created on 20 July 2002, 14:29
 */

package net.munki.irc.protocol.rfc2812;

public class MessageHandlerException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3123767628172119342L;
	private Throwable cause;
    /**
     * Creates new <code>CommandHandlerException</code> without detail message.
     */
    public MessageHandlerException(Throwable t) {
        cause = t;
    }

    public Throwable getCause() {
        return cause;
    }
}


