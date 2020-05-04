/*
 * ConnectionException.java
 *
 * Created on 04 October 2003, 18:18
 */

package net.munki.irc.connection;

public class ConnectionException extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ConnectionException() {
    }
    
    public ConnectionException(String msg) {
        super(msg);
    }
    
    public ConnectionException(Throwable exception) {
        super(exception);
    }
    
    public ConnectionException(String msg, Throwable exception) {
        super(msg, exception);
    }
    
}
