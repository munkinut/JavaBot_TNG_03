/*
 * ConnectionFactory.java
 *
 * Created on 22 March 2002, 16:22
 */

package net.munki.irc.connection;

import net.munki.irc.server.Server;

import java.io.IOException;

/** Creates connections to servers
 */
public class ConnectionFactory {
    
    /** Prevents instantiation of this class. */    
    private ConnectionFactory() {
    }

    /** Return a connection to a server
     * @param server Server to connect to
     * @throws IOException Thrown if creating the connection fails
     * @return Connection to a server
     */    
    public static Connection getConnection(Server server) throws ConnectionException {
        String host = server.getHost();
        int port = server.getPreferredPort();
        return new Connection(host, port);
    }
    
}
