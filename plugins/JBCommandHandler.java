/*
 * JBCommandHandler.java
 *
 * Handles our commands
 *
 * Created on 19 July 2002, 08:17
 */

import net.munki.irc.bot.BotEnv;
import net.munki.irc.connection.Connection;
import net.munki.irc.event.IRCCommandEvent;
import net.munki.irc.handlers.command.IRCCommandAdapter;
import net.munki.irc.protocol.rfc2812.MessageHandlerException;
import net.munki.irc.protocol.rfc2812.MessageNames;
import net.munki.util.string.StringTool;

import java.io.IOException;
import java.util.logging.Logger;

/** Extends the IRCCommandAdapter to provide handling of commands.
 *  In this case it handles the CHANNEL_MODE command.
 */
public class JBCommandHandler extends IRCCommandAdapter {
    
    private Logger logger;
    /** Initialises a new IRCCommandHandler.
     */    
    public JBCommandHandler() {
        super();
        logger = Logger.getLogger(this.getClass().getName());
        connection = null;
    }
    
    /** Initialises a new IRCCommandHandler with a connection.
     * @param connection The connection
     */    
    public JBCommandHandler(Connection connection) {
        super(connection);
        logger = Logger.getLogger(this.getClass().getName());
    }
    
    /** The dispatch method used to examine events and take the required actions.
     * @param evt The event
     * @throws MessageHandlerException Thrown when a handler fails to handle the dispatched message.
     */    
    public void dispatch(IRCCommandEvent evt) throws MessageHandlerException {
        if ((evt.getSource() instanceof BotEnv) && (evt.getActionCommand() instanceof String)) {
            logger.fine("Command event is valid; dispatching ...");
            this.handleMessage(evt);
        }
    }
    
    private void handleMessage(IRCCommandEvent evt) throws MessageHandlerException {

        // BotEnv env = (BotEnv)evt.getSource();
        String message = (String)evt.getActionCommand();

        if (message.equals(MessageNames.CHANNEL_MODE)) {
            logger.fine("Command Handler received a CHANNEL_MODE command ...");
            String channel = "";
            String modes = "";
            String nicknames = "";
            Object[] parameters = (evt.getParameters()).toArray();
            if (parameters.length == 3) {
                channel = (String)parameters[0];
                modes = (String)parameters[1];
                nicknames = (String)parameters[2];
                logger.fine(StringTool.cat(new String[] {
                    "Dispatching MODE command on ",
                    channel,
                    " with modes ",
                    modes,
                    " for ",
                    nicknames,
                    " ..."
                }));
                this.MODE(channel, modes, nicknames);

            }
            else logger.warning("Invalid number of parameters for CHANNEL_MODE command ...");
        }
        else if (message.equals(MessageNames.WHO)) {
            logger.fine("Command Handler received a WHO command ...");
            String mask = "";
            String operator = "";
            Object[] parameters = (evt.getParameters()).toArray();
            if (parameters.length == 2) {
                mask = (String)parameters[0];
                operator = (String)parameters[1];
                logger.fine(StringTool.cat(new String[] {
                    "Dispatching WHO command for ",
                    mask,
                    " ..."
                }));
                this.WHO(mask, operator);
            }
            else logger.warning("Invalid number of parameters for WHO command ...");
        }
        
        // env = null;
    }

    /** 3.2.3 Mode message
     * @param channel The channel to which the mode command is being sent.
     * @param modes The modes being applied.
     * @param params The mode parameters.
     * @throws MessageHandlerException Thrown if the command handler fails to handle our fired command.
     */
    public void MODE(String channel, String modes, String params) throws MessageHandlerException {
        try {
            super.write(StringTool.cat(new String[] {"MODE ", channel, " ", modes, " ", params}));
        }
        catch (IOException ioe) {
            throw new MessageHandlerException(ioe);
        }
    }
    
    public void WHO(String mask, String operator) throws MessageHandlerException {
        try {
            super.write(StringTool.cat(new String[] {"WHO ", mask, " ", operator}));
        }
        catch (IOException ioe) {
            throw new MessageHandlerException(ioe);
        }
    }
}
