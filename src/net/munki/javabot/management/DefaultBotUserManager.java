/*
 * DefaultBotUserManager.java
 *
 * Created on 29 September 2003, 15:20
 */

package net.munki.javabot.management;

import net.munki.irc.channel.Channel;
import net.munki.irc.channel.ChannelUser;
import net.munki.util.string.StringTool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** A DefaultBotUserManager. */
public class DefaultBotUserManager implements BotUserManagerInterface {
    
    private static DefaultBotUserManager botUserManager;
    
    /** The name of the users file containing all of the bot users and their
     * permissions.
     */    
    public static final String USERFILE = StringTool.cat(new String[] {
        "config",
        File.separator,
        "users.conf"
    });
    /** The configuration separator.  A ':' by default. */    
    public static final String CONF_SEPARATOR = ":";
    
    private final Logger logger;

    private DefaultBotUserManager() {
        logger = Logger.getLogger(this.getClass().getName());
    }
    
    /** Returns a singleton instance of the class.
     * @return A DefaultBotUserManager.
     */    
    public static synchronized DefaultBotUserManager getInstance() {
        if (botUserManager == null) botUserManager = new DefaultBotUserManager();
        return botUserManager;
    }
    
    /** Determines whether or not the given user is allowed to op.
     * @param channelUser The user trying to op someone through the bot.
     * @return True if op is allowed, otherwise false.
     */    
    public boolean canOp(ChannelUser channelUser) {
        return userHasFlag("o", channelUser);
    }
    
    /** Determines whether or not the given user is allowed to deop.
     * @param channelUser The user trying to deop someone through the bot.
     * @return True if deop is allowed, otherwise false.
     */    
    public boolean canDeop(ChannelUser channelUser) {
        return userHasFlag("O", channelUser);
    }
    
    /** Determines whether or not the given user is allowed to voice.
     * @param channelUser The user trying to voice someone through the bot.
     * @return True if voice is allowed, otherwise false.
     */    
    public boolean canVoice(ChannelUser channelUser) {
        return userHasFlag("v", channelUser);
    }

    @Override
    public boolean canOp(ChannelUser channelUser, Channel myChannel) {
        return false;
    }

    @Override
    public boolean canDeop(ChannelUser channelUser, Channel myChannel) {
        return false;
    }

    @Override
    public boolean canVoice(ChannelUser channelUser, Channel myChannel) {
        return false;
    }

    /** Determines whether or not the given user is allowed to devoice.
     * @param channelUser The user trying to devoice someone through the bot.
     * @return True if devoice is allowed, otherwise false.
     */    
    public boolean canDevoice(ChannelUser channelUser, Channel channel) {
        return userHasFlag("V", channelUser);
    }
    
    private synchronized boolean userHasFlag(String flag, ChannelUser channelUser) {
        boolean returnValue = false;
        String hostmask = StringTool.cat(new String[] {
            channelUser.getIdent(),
            "@",
            channelUser.getHost()
        });
        logger.info(StringTool.cat(new String[] {"Checking ", hostmask, " has ",
            flag, " flag ..."}));
            File userFile = null;
        try {
            userFile = new File(USERFILE);
            BufferedReader br = new BufferedReader(new FileReader(userFile));
            Pattern hostPattern = Pattern.compile(hostmask);
            Matcher hostMatcher;
            String input;
            int line = 0;
            while ((input = br.readLine()) != null) {
                line++;
                hostMatcher = hostPattern.matcher(input);
                if (hostMatcher.find()) {
                    logger.info(StringTool.cat(new String[] {
                        "Host found in config at line ",
                        Integer.toString(line),
                        " ..."}));
                    String[] parts = input.split(CONF_SEPARATOR);
                    if (parts.length >= 2) {
                        String flags = parts[1];
                        Pattern flagPattern = Pattern.compile(flag);
                        Matcher flagMatcher = flagPattern.matcher(flags);
                        if (flagMatcher.find()) {
                            logger.info(StringTool.cat(new String[] {
                                "Flag ",
                                flag,
                                " found ..."}));
                            returnValue = true;
                        }
                        else {
                            logger.info(StringTool.cat(new String[] {
                            "Flag ",
                            flag,
                            " not found ..."}));
                        }
                    }
                    else logger.warning(StringTool.cat(new String[] {
                        "Config file format is corrupt at line ",
                        Integer.toString(line),
                        " ..."}));
                    break;
                }
                else {
                    logger.info("Host not found in config ...");
                }
            }
            br.close();
        }
        catch (java.io.IOException ioe) {
            logger.warning(StringTool.cat(new String[] {
                "Error reading config file: ",
                ioe.getMessage(),
                ". File : ",
                userFile.getAbsolutePath(),
                " ..."}));
        }
        return returnValue;
    }
    
/*    private String escape(String toEscape) {
        StringBuffer target = new StringBuffer();
        StringBuffer source = new StringBuffer(toEscape);
        for (int i = 0; i < source.length(); i++) {
            char thing = source.charAt(i);
            if (thing == '\\') {
                target.append(thing);
                target.append(thing);
            }
        }
        return target.toString();
    }
*/
}
