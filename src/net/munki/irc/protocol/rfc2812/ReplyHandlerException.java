/*
 * ReplyHandlerException.java
 *
 * Created on 20 July 2002, 14:29
 */

package net.munki.irc.protocol.rfc2812;

public class ReplyHandlerException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5926630868659448254L;
	private final Throwable cause;
    /**
     * Creates new <code>CommandHandlerException</code> without detail message.
     */
    public ReplyHandlerException(Throwable t) {
        cause = t;
    }

    public Throwable getCause() {
        return cause;
    }
}


