/*
 * BotCore.java
 *
 * Created on 17 July 2002, 16:35
 */

package net.munki.irc.bot;

import net.munki.irc.channel.Channel;
import net.munki.irc.connection.Connection;
import net.munki.irc.connection.ConnectionException;
import net.munki.irc.connection.ConnectionFactory;
import net.munki.irc.event.*;
import net.munki.irc.handlers.command.IRCCommandHandler;
import net.munki.irc.handlers.message.IRCMessageHandler;
import net.munki.irc.handlers.reply.IRCReplyHandler;
import net.munki.irc.handlers.script.beanshell.BeanshellScriptHandler;
import net.munki.irc.handlers.script.jacl.JaclScriptHandler;
import net.munki.irc.handlers.script.jython.JythonScriptHandler;
import net.munki.irc.message.CommandMessageInterface;
import net.munki.irc.message.GenericMessageInterface;
import net.munki.irc.message.MessageFactory;
import net.munki.irc.message.ReplyMessageInterface;
import net.munki.irc.protocol.rfc2812.MessageHandlerException;
import net.munki.irc.protocol.rfc2812.MessageNames;
import net.munki.irc.protocol.rfc2812.ReplyHandlerException;
import net.munki.irc.server.Server;
import net.munki.irc.util.Validator;
import net.munki.jServer.ListenerManager;
import net.munki.jServer.ListenerManagerException;
import net.munki.jServer.ServiceInterface;
import net.munki.jServer.ServiceListenerInterface;
import net.munki.util.classloader.VanillaClassLoader;
import net.munki.util.string.StringTool;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

/** A bot core providing basic minimal functionality for connecting to an IRC server.
 */
public class BotCore implements PropertyChangeListener, ServiceListenerInterface {
    
    /** The default nickname to use if one is not supplied. */    
    private static final String DEFAULT_NICK = "JB_TNG";
    /** The default port on which to run the control service. */    
    private static final int DEFAULT_CONTROL_PORT = 12321;
    /** The package path to the control service class. */    
    private static final String CONTROL_SERVICE = "net.munki.irc.control.ControlService";
    /** The path to the plugins directory. */
    private static final String PLUGINS_DIR = "plugins";
    /** The file separator. */
    private static final String FILE_SEPARATOR = File.separator;

//    private void setNews(String newValue) {
//    }

    /** The bot environment, a complimentary class which provides
     * an API to scripts and internal components.
     */
    private BotEnv env;
    
    /** The user name that the bot will run under. */    
    private final String user;
    /** The real name the bot will run under. */    
    private final String real;
    /** The server the bot will connect to. */    
    private final Server server;
    /** The connection the bot will use to talk to the server. */    
    private Connection connection;

    private String message;
    
    /** The listener manager that runs the control service. */    
    private ListenerManager controlListener;
    /** The logger to which all log messages will be sent. */    
    private Logger logger;
    
    /** Starts the bot core.
     * @param beanshell True if the bot is to run the beanshell script handler, otherwise false.
     * @param jython True if the bot is to run the jython script handler, otherwise false.
     * @param jacl True if the bot is to run the jacl script handler, otherwise false.
     * @param nicknames An array of nicknames to use
     * @param chans An array of channel names to join
     * @param host Hostname of server
     * @param port Port number to connect to
     * @param user User name
     * @param real Real name
     */    
    public BotCore(String host, int port, String[] nicknames, String user,
                   String real, String[] chans, boolean beanshell, boolean jython, boolean jacl) {
        this.user = user;
        this.real = real;
        this.server = new Server(host, port);
        this.connection = null;
        this.initLogger();
        this.initEnvironment(nicknames, chans);
        this.initControl();
        this.initDefaultHandlers(beanshell, jython, jacl);
        this.initPlugins();
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.setMessage((String) evt.getNewValue());
    }

    private void setMessage(String newValue) {
        this.message = newValue;
    }

    private String getMessage() {
        return this.message;
    }

    /** Initialises the bot environment.
     * @param nicknames The list of nicknames the bot can use.
     * @param chans The list of channels the bot can join.
     */    
    private void initEnvironment(String[] nicknames, String[] chans) {
        logger.fine("Initialising environment ...");
        ArrayList messageListeners = new ArrayList();
        ArrayList commandListeners = new ArrayList();
        ArrayList replyListeners = new ArrayList();
        ArrayList scriptListeners = new ArrayList();
        int nickIndex = -1;
        String[] nicks = new String[nicknames.length + 1];
        System.arraycopy(nicknames, 0, nicks, 0, nicknames.length);
        nicks[nicknames.length] = BotCore.DEFAULT_NICK;
        ArrayList<Channel> channels = new ArrayList<>();
        for (int i = 0; i < chans.length; i++) {
            if (Validator.validChannelName(chans[i])) {
                Channel channel = new Channel(chans[i], "", "", new ArrayList());
                channels.add(channel);
            }
        }
        PrintStream output = System.out;
        env = new BotEnv(nicks, nickIndex, channels, messageListeners, commandListeners, replyListeners, scriptListeners, output);
    }
    
    /** Initialises the control service. */    
    private void initControl() {
        logger.fine("Initialising control thread ...");
        controlListener = new ListenerManager();
        try {
            controlListener.addListener(DEFAULT_CONTROL_PORT, CONTROL_SERVICE, this, null);
            controlListener.start();
        }
        catch (ListenerManagerException lme) {
            logger.warning(StringTool.cat(new String[] {
                "Could not start control thread. Message was ",
                lme.getMessage(),
                " ..."
            }));
        }
    }
    
    /** Initialises the logger. */    
    private void initLogger() {
        logger = Logger.getLogger(this.getClass().getName());
    }
    
    /** Initialises the default handlers. */    
    private void initDefaultHandlers(boolean beanshell, boolean jython, boolean jacl) {
        logger.fine("Initialising default handlers ...");
        registerMessageHandler(new IRCMessageHandler());
        registerReplyHandler(new IRCReplyHandler());
        registerCommandHandler(new IRCCommandHandler());
        if (beanshell) registerScriptHandler(new BeanshellScriptHandler());
        if (jython) registerScriptHandler(new JythonScriptHandler());
        if (jacl) registerScriptHandler(new JaclScriptHandler());
    }
    
    /** Initialises the plugins. */    
    private void initPlugins() {
        logger.fine("Initialising plugins ...");
        ClassLoader classLoader = new VanillaClassLoader(BotCore.class.getClassLoader(), PLUGINS_DIR);
        logger.fine("Acquiring plugin list ...");
        List classesToLoad = getPluginList(PLUGINS_DIR);
        for (int i = 0; i < classesToLoad.size(); i++) {
            String classToLoad = (String)classesToLoad.get(i);
            try {
                Class myClass = classLoader.loadClass(classToLoad);
                logger.fine(StringTool.cat(new String[] {
                    "Plugin ",
                    myClass.getName(), 
                    " found ..."
                }));
                if (IRCCommandListener.class.isAssignableFrom(myClass)) {
                    IRCCommandListener icl = (IRCCommandListener)myClass.getDeclaredConstructor().newInstance();
                    logger.fine(StringTool.cat(new String[] {
                        "Plugin ",
                        myClass.getName(),
                        " initialised ..."
                    }));
                    registerCommandHandler(icl);
                }
                else if (IRCMessageListener.class.isAssignableFrom(myClass)) {
                    IRCMessageListener iml = (IRCMessageListener)myClass.getDeclaredConstructor().newInstance();
                    logger.fine(StringTool.cat(new String[] {
                        "Plugin ",
                        myClass.getName(),
                        " initialised ..."
                    }));
                    registerMessageHandler(iml);
                }
                else if (IRCReplyListener.class.isAssignableFrom(myClass)) {
                    IRCReplyListener irl = (IRCReplyListener)myClass.getDeclaredConstructor().newInstance();
                    logger.fine(StringTool.cat(new String[] {
                        "Plugin ",
                        myClass.getName(),
                        " initialised ..."
                    }));
                    registerReplyHandler(irl);
                }
                else logger.warning(StringTool.cat(new String[] {
                    "The plugin ",
                    classToLoad,
                    " was not valid.  Please ensure it extends one of the ",
                    " handler classes and that it ends with a .mod extension."
                }));
            }
            catch (ClassNotFoundException cnfe) {
                logger.warning(StringTool.cat(new String[] {
                    "The class ",
                    classToLoad,
                    " could not be found."
                }));
            }
            catch (InstantiationException ie) {
                logger.warning(StringTool.cat(new String[] {
                    "The class ",
                    classToLoad,
                    " could not be instantiated."
                }));
            }
            catch (IllegalAccessException iae) {
                logger.warning(StringTool.cat(new String[] {
                    "The class ",
                    classToLoad,
                    " could not be accessed.",
                    " Please check you security manager settings",
                    " and file permissions."
                }));
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static ArrayList getPluginList(String location) {
        File dir = new File(location);
        ArrayList outList = new ArrayList();
        if (!dir.exists()) return outList;
        File[] filesList = dir.listFiles();
        for (int i = 0; i < filesList.length; i++) {
            File file = filesList[i];
            String fileStr = file.toString();
            if (file.isDirectory()) outList.addAll(getPluginList(fileStr));
            else { // it's a file
                String replaceSlash;
                String replacement = ".";
                String replaceClass = ".mod";
                String replacePlugins = StringTool.cat(new String[] {PLUGINS_DIR, "."});
                String empty = "";
                if (FILE_SEPARATOR.equals("\\")) replaceSlash = "\\" + FILE_SEPARATOR;
                else replaceSlash = FILE_SEPARATOR;
                String unslashedFile = fileStr.replaceAll(replaceSlash, replacement);
                String outFileWithPlugins = unslashedFile.replaceAll(replaceClass, empty);
                String outFile = outFileWithPlugins.replaceAll(replacePlugins, empty);
                outList.add(outFile);
            }
        }
        return outList;
    }
    
    /** Sets the output stream.
     * @param out Output stream to use
     */    
    public void setOutput(PrintStream out) {
        env.setOutput(out);
    }
    
    /** Registers a message handler, allowing multiple message handlers.
     * @param messageHandler A message handler that handles messages defined in net.munki.irc.protocol.rfc2812.MessageNames
     */    
    public void registerMessageHandler(IRCMessageListener messageHandler) {
        env.registerMessageHandler(messageHandler);
    }
    
    /** Unregister a message handler.
     * @param messageHandler Message handler to unregister
     */    
    public void unregisterMessageHandler(IRCMessageListener messageHandler) {
        env.unregisterMessageHandler(messageHandler);
    }
    
    /** Registers a reply handler, allowing multiple reply handlers.
     * @param replyHandler The reply handler to register.
     */    
    public void registerReplyHandler(IRCReplyListener replyHandler) {
        env.registerReplyHandler(replyHandler);
    }
    
    /** Unregister a reply handler.
     * @param replyHandler The reply handler to unregister.
     */    
    public void unregisterReplyHandler(IRCReplyListener replyHandler) {
        env.unregisterReplyHandler(replyHandler);
    }
    
    /** Registers a command handler.
     * @param commandHandler Command handler to register
     */    
    public void registerCommandHandler(IRCCommandListener commandHandler) {
        env.registerCommandHandler(commandHandler);
    }
    
    /** Unregister a command handler.
     * @param commandHandler Command handler to unregister
     */    
    public void unregisterCommandHandler(IRCCommandListener commandHandler) {
        env.unregisterCommandHandler(commandHandler);
    }
    
    /** Registers a script handler.
     * @param scriptHandler Script handler to register
     */    
    public void registerScriptHandler(IRCScriptListener scriptHandler) {
        env.registerScriptHandler(scriptHandler);
    }
    
    /** Unregister a script handler.
     * @param scriptHandler Script handler to unregister
     */    
    public void unregisterScriptHandler(IRCScriptListener scriptHandler) {
        env.unregisterScriptHandler(scriptHandler);
    }
    
    /** Makes the bot connect to a server.
     * @return True if a connection was established, false if not
     */    
    public boolean connect() {
        boolean success;
        if (server != null) {
            report(StringTool.cat(new String[] {"Requesting a connection to ", server.toString(), " ..."}));
            try {
                connection = ConnectionFactory.getConnection(server);
                if (connection != null) {
                    logger.info("Initialising connection ...");
                    this.activateCommandHandlers();
                    connection.addPropertyChangeListener(this);
                    connection.start();
                    success = true;
                }
                else {
                    logger.severe("Connection was dead ...");
                    success = false;
                }
            }
            catch (ConnectionException ioe) {
                logger.severe(StringTool.cat(new String[] {
                    "Could not connect to host ",
                    server.toString(),
                    ". Message was ",
                    ioe.getMessage()
                }));
                connection = null;
                success = false;
            }
        }
        else {
            logger.severe("Server has not been specified ...");
            connection = null;
            success = false;
        }
        return success;
    }
    
    /** Sends registration information to the server.
     * @return True if registration succeeded, false if not
     */    
    public boolean signOn() {
        String nick = this.nextNick();
        logger.fine(StringTool.cat(new String[] {"Selected nick is ", nick, " ..."}));
        boolean success = false;
        if (this.nick(nick) && this.user(user, real)) {
            logger.fine("Sign-on information sent ...");
            success = true;
        }
        else {
            logger.severe("Sign-on failed ...");
        }
        return success;
    }
    
    /** Chooses a new nickname from the list in a case, for example, where the server rejects our chosen nickname for registration.
     * @return The next available nickname from our list
     */    
    public String nextNick() {
        return env.nextNick();
    }
    
    /** Allows a connection to send message strings to the bot.
     * @param message A message string
     */    
    public void update(String message) {
        logger.fine("Valid message received ...");
        String msg = (String)message;
        report(message);
        this.handleMessage(message);
    }
    
    /** Tells the bot environment to listen for commands. */    
    private void activateCommandHandlers() {
        env.activateCommandHandlers(connection);
    }
    
    /** Fires a NICK command event.
     * This is picked up by a suitable, registered
     * command listener in the environment.
     * @param nick The nickname to send.
     * @return True if NICK command event was successfully
     * dispatched, otherwise false.
     */    
    private boolean nick(String nick) {
        boolean success;
        if (connection != null) {
            IRCCommandEvent evt = new IRCCommandEvent(env, MessageNames.NICK);
            evt.addParameter(nick);
            try {
                logger.fine("Firing NICK command event ...");
                env.fireIRCCommandEvent(evt);
                success = true;
            }
            catch (MessageHandlerException che) {
                logger.warning("Command handler failed, nick not sent");
                success = false;
            }
        }
        else {
            logger.warning("Connection was null, nick not sent ...");
            success = false;
        }
        return success;
    }
    
    /** Fires a USER command event.  This is picked up by a
     * suitable, registered command listener in the environment.
     * @param user The username to use.
     * @param real The real name to use.
     * @return True if the USER command was successfully
     * dispatched, otherwise false.
     */    
    private boolean user(String user, String real) {
        boolean success;
        if (connection != null) {
            IRCCommandEvent evt = new IRCCommandEvent(env, MessageNames.USER);
            evt.addParameter(user);
            evt.addParameter("8");
            evt.addParameter("*");
            evt.addParameter(real);
            try {
                logger.fine("Firing USER command event ...");
                env.fireIRCCommandEvent(evt);
                success = true;
            }
            catch (MessageHandlerException che) {
                logger.warning("Command handler failed, user not sent");
                success = false;
            }
        }
        else {
            logger.warning("Connection was null, USER not sent ...");
            success = false;
        }
        return success;
    }
    
    /** Parses message strings from the connection into either
     * reply or message objects, then dispatches them to any
     * registered listeners.
     * @param msg The message string to parse.
     */    
    private void handleMessage(String msg) {
        GenericMessageInterface message = MessageFactory.getMessage(msg);
        if (message != null) {
            if (message instanceof ReplyMessageInterface) {
                IRCReplyEvent evt = new IRCReplyEvent(env, message);
                logger.fine("Firing reply event ...");
                try {
                    env.fireIRCReplyEvent(evt);
                }
                catch (ReplyHandlerException mhe) {
                    logger.warning("A reply handler failed to fire reply event ...");
                }
            }
            else if (message instanceof CommandMessageInterface) {
                IRCMessageEvent evt = new IRCMessageEvent(env, message);
                logger.fine("Firing message event ...");
                try {
                    env.fireIRCMessageEvent(evt);
                }
                catch (MessageHandlerException mhe) {
                    logger.warning("A message handler failed to fire message event ...");
                }
            }
            else{
                logger.fine("Message type was not recognised, ignoring ...");
            }
        }
        else {
            logger.fine("Message was not understood, ignoring ...");
        }
    }
    
    /** Sends output to the output device via the environment.
     * @param msg The message to output.
     */    
    private void report(String msg) {
        env.report(msg);
    }
    
    /** Stops the connection and the control listener.
     */    
    public void kill() {
        logger.fine("Kill called ...");
        report("\nKill requested, please wait ...\n");
        if (connection != null) connection.stop();
        else logger.warning("Kill requested but connection was already null ...");
        if (controlListener != null) controlListener.kill();
        else logger.warning("Kill requested but control listener was already null ...");
    }
    
    /** Allows the bot to be notified of commands
     * received through it's control service.
     * @param source The source of the command.  This should be an
     * object that implements net.munki.jServer.ServiceInterface.
     * @param message The command message.  This should be a String
     * containing a command received via the control service.
     */    
    public void notify(Object source, Object message) {
        if (source instanceof ServiceInterface) {
            logger.fine("Received command from valid control source ...");
            if (message instanceof String) {
                String msg = (String)message;
                logger.info(msg + " control command received, please wait ...");
                if (msg.equals("QUIT")) {
                    report("\nQUIT message received, please wait ...\n");
                    this.kill();
                }
                else {
                    logger.warning("Invalid control command received, ignoring ...");
                }
            }
            else {
                logger.warning("Invalid control message receieved, ignoring ...");
            }
        }
        else {
            logger.warning("Invalid control service sending command, ignoring ...");
        }
    }

}
