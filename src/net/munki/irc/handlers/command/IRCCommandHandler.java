/*
 * IRCCommandHandler.java
 *
 * Handles our commands
 *
 * Created on 19 July 2002, 08:17
 */

package net.munki.irc.handlers.command;

import net.munki.irc.bot.BotEnv;
import net.munki.irc.connection.Connection;
import net.munki.irc.event.IRCCommandEvent;
import net.munki.irc.protocol.rfc2812.MessageHandlerException;
import net.munki.irc.protocol.rfc2812.MessageNames;
import net.munki.util.string.StringTool;

import java.io.IOException;
import java.util.logging.Logger;

/** Extends the IRCCommandAdapter to provide handling of commands.
 */
public class IRCCommandHandler extends IRCCommandAdapter {
    
    /** The logger to which all log data for this class should be sent. */    
    private final Logger logger;
    /** Initialises a new IRCCommandHandler.
     */    
    public IRCCommandHandler() {
        super();
        logger = Logger.getLogger(this.getClass().getName());
        connection = null;
    }
    
    /** Initialises a new IRCCommandHandler with a connection.
     * @param connection The connection
     */    
    public IRCCommandHandler(Connection connection) {
        super(connection);
        logger = Logger.getLogger(this.getClass().getName());
    }
    
    /** The dispatch method used to examine events and take the required actions.
     * @param evt The event
     * @throws MessageHandlerException Thrown if a handler fails to handle the dispatched command.
     */    
    public void dispatch(IRCCommandEvent evt) throws MessageHandlerException {
        if ((evt.getSource() instanceof BotEnv) && (evt.getActionCommand() instanceof String)) {
            logger.fine("Command Event valid; handling ...");
            this.handleMessage(evt);
        }
        else logger.warning("Invalid Command Event ...");
    }
    
    /** Parses raw data from the connection into messages or replies.
     * @param evt The message event to process.
     * @throws MessageHandlerException Thrown if a handler fails to handle the dispatched message.
     */    
    private void handleMessage(IRCCommandEvent evt) throws MessageHandlerException {

        // BotEnv env = (BotEnv)evt.getSource();
        String message = (String)evt.getActionCommand();

        switch (message) {
            case MessageNames.NICK -> {
                logger.fine("Command Handler received a NICK command ...");
                String nickname = "";
                Object[] parameters = (evt.getParameters()).toArray();
                if (parameters.length == 1) {
                    nickname = (String) parameters[0];
                }
                logger.fine(StringTool.cat(new String[]{"Dispatching NICK command for ", nickname, " ..."}));
                this.NICK(nickname);
            }
            case MessageNames.USER -> {
                logger.fine("Command Handler received a USER command ...");
                String username = "";
                String modes = "";
                String unused = "";
                String real = "";
                Object[] parameters = (evt.getParameters()).toArray();
                if (parameters.length == 4) {
                    username = (String) parameters[0];
                    modes = (String) parameters[1];
                    unused = (String) parameters[2];
                    real = (String) parameters[3];
                }
                logger.fine(StringTool.cat(new String[]{"Dispatching USER command for ", username, " ..."}));
                this.USER(username, modes, unused, real);
            }
            case MessageNames.JOIN -> {
                logger.fine("Command Handler received a JOIN command ...");
                Object[] parameters = (evt.getParameters()).toArray();
                String[] channels;
                if (parameters.length == 1) {
                    channels = (String[]) parameters[0];
                } else {
                    channels = new String[]{""};
                }
                logger.fine("Dispatching JOIN command ...");
                this.JOIN(channels);
            }
            case MessageNames.PONG -> {
                logger.fine("Command Handler received a PONG command ...");
                Object[] parameters = (evt.getParameters()).toArray();
                String reply = "";
                if (parameters.length == 1) {
                    reply = (String) parameters[0];
                }
                logger.fine(StringTool.cat(new String[]{"Dispatching PONG command : ", reply, "..."}));
                this.PONG(reply);
            }
            case MessageNames.PRIVMSG -> {
                logger.fine("Command Handler received a PRIVMSG command ...");
                Object[] parameters = (evt.getParameters()).toArray();
                String recipient = "";
                String msg = "";
                if (parameters.length == 2) {
                    recipient = (String) parameters[0];
                    msg = (String) parameters[1];
                    logger.finer(StringTool.cat(new String[]{"Command handler reports recipient is ", recipient}));
                    logger.finer(StringTool.cat(new String[]{"Command handler reports message is ", msg}));
                }
                logger.fine(StringTool.cat(new String[]{"Dispatching PRIVMSG command to ", recipient, " ..."}));
                this.PRIVMSG(recipient, msg);
            }
            default -> logger.finer("Command is not handled by this handler ...");
        }
        
        // env = null;
    }
    
    /** 3.1.2 Nick Message
     * @param nick
     * @throws MessageHandlerException
     */
    public void NICK(String nick) throws MessageHandlerException {
        try {
            logger.fine("Writing NICK command ...");
            super.write(StringTool.cat(new String[] {"NICK ", nick}));
        }
        catch (IOException ioe) {
            logger.warning("Failed to dispatch NICK command ...");
            throw new MessageHandlerException(ioe);
        }
    }
    
    /** 3.1.3 User Message
     * @param user
     * @param mode
     * @param unused
     * @param real
     * @throws MessageHandlerException
     */
    public void USER(String user, String mode, String unused, String real) throws MessageHandlerException {
        try {
            logger.fine("Writing USER command ...");
            super.write(StringTool.cat(new String[] {"USER ", user, " ", mode, " ", unused, " :", real}));
        }
        catch (IOException ioe) {
            logger.warning("Failed to dispatch USER command ...");
            throw new MessageHandlerException(ioe);
        }
    }

    /** 3.2.1 Join message
     * @param channels
     * @throws MessageHandlerException
     */
    public void JOIN(String[] channels) throws MessageHandlerException {
        String chans = "";
        for (int i = 0; i < channels.length; i++) {
            if (i == channels.length - 1) chans = StringTool.cat(new String[] {chans, channels[i]});
            else chans = StringTool.cat(new String[] {chans, channels[i], ","});
        }
        try {
            logger.fine(StringTool.cat(new String[] {"Writing JOIN command for ", chans}));
            super.write(StringTool.cat(new String[] {"JOIN ", chans}));
        }
        catch (IOException ioe) {
            logger.warning("Failed to dispatch JOIN command ...");
            throw new MessageHandlerException(ioe);
        }
    }

    /** 3.3.1 Private messages
     * @param target
     * @param text
     * @throws MessageHandlerException
     */
    public void PRIVMSG(String target, String text) throws MessageHandlerException {
        try {
            logger.fine("Writing PRIVMSG command ...");
            super.write(StringTool.cat(new String[] {"PRIVMSG ", target, " :", text}));
        }
        catch (IOException ioe) {
            logger.warning("Failed to dispatch PRIVMSG command ...");
            throw new MessageHandlerException(ioe);
        }
    }
    
    /** 3.7.3 Pong message
     * @param server_1
     * @throws MessageHandlerException
     */
    public void PONG(String server_1) throws MessageHandlerException {
        try {
            logger.fine("Writing PONG command ...");
            super.write(StringTool.cat(new String[] {"PONG ", server_1}));
        }
        catch (IOException ioe) {
            logger.warning("Failed to write PONG command ...");
            throw new MessageHandlerException(ioe);
        }
    }
    
}
