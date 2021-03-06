/*
 * Connection.java
 *
 * Created on 22 March 2002, 16:42
 */

package net.munki.irc.connection;

import net.munki.util.string.StringTool;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.*;
import java.net.Socket;
import java.util.logging.Logger;

/** Represents a connection to an IRC server
 */
public class Connection implements Runnable {

    private final PropertyChangeSupport support;
    
    /** Line terminator string
     */    
    private static final String LINE_TERMINATOR = "\r\n";

    String inbound;

    /** Reader for the incoming data
     */    
    private final BufferedReader in;
    /** Writer for the outgoing data
     */    
    private final BufferedWriter out;
    /** Thread for this object to run in
     */    
    private Thread connectionThread = null;
    /** Connected flag
     */    
    private boolean connected;
    /** The logger to which all log data should be sent for this class. */    
    private Logger logger;
    
    /** Creates new Connection
     * @param host Hostname of server
     * @param port Port number of server
     * @throws IOException Thrown if creating connection fails
     */
    public Connection(String host, int port) throws ConnectionException {
        initLogger();
        support = new PropertyChangeSupport(this);
        try {
            /* Socket for connection to the server
             */
            Socket socket = new Socket(host, port);
            this.in = new BufferedReader(
                        new InputStreamReader(
                          socket.getInputStream()
                        )
                      );
            this.out = new BufferedWriter(
                         new OutputStreamWriter(
                           socket.getOutputStream()
                         )
                       );
            connected = true;
        }
        catch (IOException ioe) {
            connected = false;
            throw new ConnectionException(ioe);
        }
        catch (SecurityException se) {
            connected = false;
            throw new ConnectionException(se);
        }
    }
    
    /** Initialises the logger. */    
    private void initLogger() {
        logger = Logger.getLogger(this.getClass().getName());
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }


    /** Start using the connection
     */    
    public void start() {
        if (connectionThread == null) {
            logger.info("Starting connection thread ...");
            connectionThread = new Thread(this);
            connectionThread.start();
        }
    }
    
    /** Read data from the server
     */    
    public void run() {
        while ((connectionThread == Thread.currentThread()) && connected) {
            try {
                this.readLine();
            } catch (IOException e) {
                logger.info(e.getMessage());
                this.stop();
            }
        }
    }
    
    /** Stop using the connection
     */    
    public void stop() {
        logger.info("Stopping the connection ...");
        this.disconnect();
        connectionThread = null;
    }
    
    /** Read a line of data from the server
     * @throws IOException Thrown if reading data fails
     */    
    private void readLine() throws IOException {
        if ((inbound = in.readLine()) != null) {
            logger.info("READ MESSAGE FROM SERVER: " + inbound);
            PropertyChangeEvent evt = new PropertyChangeEvent(this, inbound, null, inbound);
            support.firePropertyChange(evt);
        }
        else this.stop();
    }
    
    /** Writes a message to the server.
     * @param outbound The message to send
     * @throws IOException Thrown if write to server fails
     */    
    public void writeLine(String outbound) throws IOException {
        if ((outbound != null) && (outbound.length() > 0)) {
            if (out != null) {
                out.write(StringTool.cat(new String[] {outbound, LINE_TERMINATOR}));
                out.flush();
                logger.info("WROTE MESSAGE TO SERVER: " + outbound);
            }
            else logger.warning("Output stream was null ...");
        }
        else logger.warning("Outbound string was null or empty ...");
    }
    
    /** Disconnect from the server
     */    
    private void disconnect() {
        try {
            logger.info("Disconnecting ...");
            if (out != null) out.close();
            else logger.warning("Tried to disconnect but the outstream was already null ...");
            if (in != null) in.close();
            else logger.warning("Tried to disconnect but the input was already null ...");
        }
        catch (IOException e) {
            logger.warning(e.getMessage());
        }
        finally {
            connected = false;
        }
    }
}
