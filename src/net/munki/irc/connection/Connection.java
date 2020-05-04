/*
 * Connection.java
 *
 * Created on 22 March 2002, 16:42
 */

package net.munki.irc.connection;

import net.munki.util.string.StringTool;

import java.io.*;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Logger;

/** Represents a connection to an IRC server
 */
public class Connection extends Observable implements Runnable {
    
    /** Line terminator string
     */    
    private static final String LINE_TERMINATOR = "\r\n";

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
    private boolean connected = false;
    /** The logger to which all log data should be sent for this class. */    
    private Logger logger;
    
    /** Creates new Connection
     * @param host Hostname of server
     * @param port Port number of server
     * @throws IOException Thrown if creating connection fails
     */
    public Connection(String host, int port) throws ConnectionException {
        initLogger();
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
    
    /** Start using the connection
     */    
    public void start() {
        if (connectionThread == null) {
            logger.fine("Starting connection thread ...");
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
        logger.fine("Stopping the connection ...");
        this.disconnect();
        connectionThread = null;
    }
    
    /** Read a line of data from the server
     * @throws IOException Thrown if reading data fails
     */    
    private void readLine() throws IOException {
        String inbound;
        if ((inbound = in.readLine()) != null) {
            logger.fine("Received inbound message, notifying observers ...");
            this.setChanged();
            this.notifyObservers(inbound);
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
            }
            else logger.warning("Output stream was null ...");
        }
        else logger.warning("Outbound string was null or empty ...");
    }
    
    /** Disconnect from the server
     */    
    private void disconnect() {
        try {
            logger.fine("Disconnecting ...");
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
