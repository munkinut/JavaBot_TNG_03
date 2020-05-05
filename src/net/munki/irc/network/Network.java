/*
 * Network.java
 *
 * Created on 23 March 2002, 13:48
 */

package net.munki.irc.network;

import net.munki.irc.server.Server;

import java.util.ArrayList;

/** Represents an IRC Network
 */
public class Network {

    /* Network name
     */    
    // private String name;
    /** Servers in the network
     */    
    private final ArrayList<Server> servers;

    /** Creates new Network
     */
    public Network() {
        // this.name = name;
        this.servers = new ArrayList<>();
    }
    
    /** Add a server to the network
     * @param server Server to add
     * @return Success
     */    
    public boolean addServer(Server server) {
        return servers.add(server);
    }
    
    /** Remove a server from the network
     * @param server Server to remove
     * @return Success
     */    
    public boolean removeServer(Server server) {
        return servers.remove(server);
    }
    
    /** Remove all servers from the network
     */    
    public void removeAllServers() {
        Server[] s = (Server[]) servers.toArray();
        for (Server o : s) {
            servers.remove(o);
        }
    }
    
    /** Get a server by name
     * @param name Name of server
     * @return The server
     */    
    public Server getServer(String name) {
        Server server = null;
        for (Server value : servers) {
            if (value.getHost().equals(name)) {
                server = value;
                break;
            }
        }
        return server;
    }

}
