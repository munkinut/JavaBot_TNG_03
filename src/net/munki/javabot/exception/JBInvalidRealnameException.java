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
public class JBInvalidRealnameException extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 8125246946755949262L;

	/**
     * Creates a new instance of <code>JBInvalidPortException</code> without detail message.
     */
    public JBInvalidRealnameException() {
    }
    
    /**
     * Constructs an instance of <code>JBInvalidPortException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public JBInvalidRealnameException(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of <code>JBInvalidPortException</code> with the specified detail message and chained exception.
     * @param msg the detail message.
     * @param cause the detail message.
     */
    public JBInvalidRealnameException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
