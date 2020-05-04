/*
 * JBConfigurationException.java
 *
 * Created on 05 March 2003, 11:37
 */

package net.munki.javabot.exception;

/**
 *
 * @author  Warren Milburn
 */
public class JBConfigurationException extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = -3713643718457739057L;

	/**
     * Creates a new instance of <code>JBConfigurationException</code> without detail message.
     */
    public JBConfigurationException() {
    }
    
    /**
     * Constructs an instance of <code>JBConfigurationException</code> with the specified detail message.
     * @param msg the detail message.
     */
    public JBConfigurationException(String msg) {
        super(msg);
    }
    
    /**
     * Constructs an instance of <code>JBConfigurationException</code> with the specified detail message and chained exception.
     * @param msg the detail message.
     * @param cause the chained exception
     */
    public JBConfigurationException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
