/*
 * JBInvalidPortException.java
 *
 * Created on 05 March 2003, 12:19
 */

package net.munki.javabot.exception;

/**
 *
 * @author  Warren Milburn
 */
public class JBInvalidUsernameException extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -1824146207905787437L;

	/**
     * Creates a new instance of <code>JBInvalidPortException</code> without detail message.
     */
    public JBInvalidUsernameException() {
    }
    
    /**
     * Constructs an instance of <code>JBInvalidPortException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public JBInvalidUsernameException(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of <code>JBInvalidPortException</code> with the specified detail message and chained exception.
     * @param msg the detail message.
     * @param cause the detail message.
     */
    public JBInvalidUsernameException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
