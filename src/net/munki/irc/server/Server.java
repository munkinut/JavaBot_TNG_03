/*
 * Server.java
 *
 * Created on 22 March 2002, 22:04
 */

package net.munki.irc.server;

/** Represents an IRC server
 */
public class Server {
    
    /** Default server port
     */    
    private final int DEFAULT_PORT = 6667;
    
    /** Name of server
     */    
    private final String host;
    /** Available server ports
     */    
    private final int[] ports;
    
    /** Creates new Server
     * @param host Host name
     */
    public Server(String host) {
        this.host = host;
        this.ports = new int[1];
        ports[0] = DEFAULT_PORT;
    }
    
    /** Creates new Server
     * @param host Host name
     * @param port Port
     */
    public Server(String host, int port) {
        this.host = host;
        this.ports = new int[1];
        ports[0] = port;
    }

    /** Creates new Server
     * @param host Host name
     * @param ports Available ports
     */
    public Server(String host, int[] ports) {
        this.host = host;
        this.ports = ports;
    }
    
    /** Get host name of server
     * @return Host name
     */    
    public String getHost() {
        return this.host;
    }
    
    /** Get available ports
     * @return Available ports
     */    
    public int[] getPorts() {
        return this.ports;
    }
    
    /** Get the preferred server port, either the first port in the available ports or the default port
     * @return Preferred port
     */    
    public int getPreferredPort() {
        try {
            return ports[0];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return DEFAULT_PORT;
        }
    }
    
    /** Returns a toString() representation of this class.
     * @return The hostname of this server.
     */    
    public String toString() {
        return this.host;
    }
    
    /** Determines equality with another Server object.
     * @param s The Server object with which to determine equality.
     * @return True if Server object is the same as this one, otherwise false.
     */    
    public boolean equals(Server s) {
        return ((this.getHost()).equals(s.getHost()));
    }

}
