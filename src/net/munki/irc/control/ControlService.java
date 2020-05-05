/*
 * ControlService.java
 *
 * Created on 18 September 2003, 16:41
 */

package net.munki.irc.control;

import net.munki.jServer.ServiceInterface;
import net.munki.jServer.ServiceListenerInterface;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;

// import java.io.PrintStream;

/** A control service running on a socket, which can be used to
 * pass commands to the bot.  E.g QUIT.
 * @author Warren Milburn
 */
public class ControlService implements ServiceInterface {

    /* The output stream to use for output messages. */
    // private PrintStream out;
    /** A list of listeners that need to be infomed of messages
     * on the socket.  In this case it will be a BotCore object.
     */    
    private final ArrayList<ServiceListenerInterface> serviceListeners;
    /** The logger to which log data is sent for this class. */    
    private Logger logger;

    /** Creates a new instance of ControlService */
    public ControlService() {
        initLogger();
        setOutput(System.out);
        serviceListeners = new ArrayList<>();
    }
    
    /** Initialises the logger. */    
    private void initLogger() {
        logger = Logger.getLogger(this.getClass().getName());
    }
    
    /** Returns a description of this service.
     * @return A description of this service.
     */    
    public String getServiceDescription() {
        return "Allows the IRC bot to be controlled by commands from a socket.";
    }
    
    /** Returns the name of this service.
     * @return The name of this service.
     */    
    public String getServiceName() {
        return "IRC bot control service";
    }
    
    /** Delivers the service to any connected clients.
     * @param i The input stream on which to accept commands.
     * @param o The output stream on which to reply to the client.
     */    
    public void serve(InputStream i, OutputStream o) {
        logger.info(getServiceName() + " running ...");
        BufferedReader br = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            br = new BufferedReader(new InputStreamReader(i));
            bw = new BufferedWriter(new OutputStreamWriter(o));
            pw = new PrintWriter(bw);
            pw.println("Connected to " + getServiceName() + " ...");
            pw.flush();
            String s;
            while ((s = br.readLine()) != null) {
                notifyServiceListeners(s);
                if (s.equals("QUIT")) break;
            }
            pw.println("Disconnecting from " + getServiceName() + " ...");
            pw.flush();
            Thread.sleep(2000);
        }
        catch (IOException | InterruptedException ioe) {
            logger.warning(ioe.getMessage());
        } finally {
            try {
                if (pw != null) pw.close();
                if (bw != null) bw.close();
                if (br != null) br.close();
                logger.info(getServiceName() + " finished ...");
            }
            catch (IOException ioe) {
                logger.warning(ioe.getMessage());
            }
        }
    }

    /** Sets the output stream.
     * @param ps The output stream to use.
     */
    public void setOutput(PrintStream ps) {
        // out = ps;
    }
    
    /** Adds a service listener, which is notified of messages arriving
     * on the socket.
     * @param serviceListenerInterface Any service listener that wishes to be notified
     * of messages on the socket.
     */    
    public void addServiceListener(ServiceListenerInterface serviceListenerInterface) {
        logger.info("Adding service listener ...");
        serviceListeners.add(serviceListenerInterface);
    }
    
    /** Notifies any service listeners of messages arriving on
     * the socket or of commands they need to perform.
     */    
    private void notifyServiceListeners(String message) {
        logger.info("Notifying listeners ...");
        Object[] slis = serviceListeners.toArray();
        for (Object o : slis) {
            if (o instanceof ServiceListenerInterface) {
                ServiceListenerInterface sli = (ServiceListenerInterface) o;
                sli.notify(this, message);
            }
        }
    }
}
