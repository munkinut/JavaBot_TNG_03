/*
 * IRCScriptResource.java
 *
 * Created on 27 July 2002, 17:09
 */

package net.munki.irc.handlers.script;

import net.munki.irc.bot.BotEnv;
import net.munki.irc.event.IRCCommandEvent;
import net.munki.irc.protocol.rfc2812.MessageHandlerException;
import net.munki.irc.protocol.rfc2812.MessageNames;
import net.munki.util.string.StringTool;

import java.util.logging.Logger;

/** A resource providing an API to JavaBot scripts. */
public class IRCScriptResource {
    
    /** The bot environment. */    
    private BotEnv env;
    /** The invokers's nickname. */    
    private String nick;
    /** The invokers's hostmask. */    
    private String mask;
    /** Where the command was sent.  Could be to the bot or to the channel.
     * A script command starting with "!" can be privmsg'd or can be a
     * public command.
     */    
    private String addressee;
    /** Arguments passed to the script. */    
    private String[] arguments;
    
    /** The logger to which all log data should be sent. */    
    private Logger logger;

    /** Creates new IRCScriptResource
     * @param env The bot environment.
     * @param nick The nickname of the bot.
     * @param mask The hostmask of the bot.
     * @param addressee The addressee of the script command.
     * @param arguments Any arguments to be send to the script.
     */
    public IRCScriptResource(BotEnv env, String nick, String mask, String addressee, String[] arguments) {
        this.env = env;
        this.nick = nick;
        this.mask = mask;
        this.addressee = addressee;
        this.arguments = arguments;
        logger = Logger.getLogger(this.getClass().getName());
    }
    
    /** Returns the bot's nickname.
     * @return The bot's nickname.
     */    
    public String getNick() {
        if (nick != null) return nick;
        else return "";
    }
    
    /** Returns the bot's hostmask.
     * @return The bot's hostmask.
     */    
    public String getMask() {
        if (mask != null) return mask;
        else return "";
    }
    
    /** Returns the addressee of the script.
     * @return The addressee.
     */    
    public String getAddressee() {
        if (addressee != null) return addressee;
        else return "";
    }
    
    /** Returns the arguments passed to the script.
     * @return The script arguments.
     */    
    public String[] getArguments() {
        if (arguments != null) return arguments;
        else return new String[] { "" };
    }

    /** Provides a means for the script to send messages back to the caller.
     * @param reply The reply string.
     */    
    public void reply(String reply) {
        
        // if the addressee is a channel, reply to the channel
        // otherwise the addressee should be me, so reply to nick
        String recipient = "";
        
        if (addressee.startsWith("#") || addressee.startsWith("+") ||
            addressee.startsWith("!") || addressee.startsWith("&")) {
                
                // addressee is a channel
                logger.fine("Script resource replying to a channel ...");
                recipient = addressee;
        }
        else {
            
                // addressee is the client
                logger.fine("Script resource replying to a nickname ...");
                recipient = nick;
        }
        
        // create an IRCCommandEvent and send it to the environment
        IRCCommandEvent ice = new IRCCommandEvent(env, MessageNames.PRIVMSG);
        ice.addParameter(recipient);
        ice.addParameter(reply);
        logger.finer(StringTool.cat(new String[] {"Recipient is ", recipient}));
        logger.finer(StringTool.cat(new String[] {"Reply is ", reply}));
        try {
            logger.fine("Firing command event ...");
            env.fireIRCCommandEvent(ice);
        }
        catch (MessageHandlerException mhe) {
            logger.warning(StringTool.cat(new String[] {
                "Command event handling failed. ",
                "Error was : ",
                mhe.getMessage(),
                " ..."
            }));
        }
    }
    
}
