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
public class JBInvalidPortException extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2300659399671107546L;

	/**
     * Creates a new instance of <code>JBInvalidPortException</code> without detail message.
     */
    public JBInvalidPortException() {
    }
    
    /**
     * Constructs an instance of <code>JBInvalidPortException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public JBInvalidPortException(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of <code>JBInvalidPortException</code> with the specified detail message and chained exception.
     * @param msg the detail message.
     * @param cause the detail message.
     */
    public JBInvalidPortException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
