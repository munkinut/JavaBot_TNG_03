/*
 * InvalidMessageException.java
 *
 * Created on 18 July 2002, 07:26
 */

package net.munki.irc.message;

public class InvalidMessageException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3874264857964909222L;

	/**
     * Creates new <code>InvalidMessageException</code> without detail message.
     */
    public InvalidMessageException() {
        super();
    }

    /**
     * Constructs an <code>InvalidMessageException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public InvalidMessageException(String msg) {
        super(msg);
    }
}


