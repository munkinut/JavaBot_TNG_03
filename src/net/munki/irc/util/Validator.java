/*
 * Validator.java
 *
 * Created on 19 July 2002, 15:40
 */

package net.munki.irc.util;

/** Validates the format of various things. */
public class Validator {

    /** Prevents instantiation */
    private Validator() {
    }

    /** Determines whether a given channel name is valid.
     * @param channelName The channel name to check.
     * @return True if valid, false if not.
     */    
    public static boolean validChannelName(String channelName) {
        boolean success = false;
        if ((channelName != null) && (channelName.length() > 1)) {
            char prefix = channelName.charAt(0);
            if (prefix == '!' && (channelName.length() <= 6)) {
                boolean valid = true;
                for (int i = 1; i < channelName.length(); i++) {
                    char chanChar = channelName.charAt(i);
                    if (((chanChar < '\u0041') || (chanChar > '\u005A')) &&
                        ((chanChar < '\u0030') || (chanChar > '\u0039'))) {
                            valid = false;
                            break;
                    }
                    else {
                        valid = true;
                    }
                }
                if (valid) success = true;
            }
            else if ((prefix == '#' || prefix == '+' || prefix == '&') && 
                     (channelName.length() <= 50)) {
                         boolean valid = true;
                         for (int i = 1; i < channelName.length(); i++) {
                             char chanChar = channelName.charAt(i);
                             if (((chanChar < '\u0001') || (chanChar > '\u0006')) &&
                                 ((chanChar < '\u0008') || (chanChar > '\u0009')) &&
                                 ((chanChar < '\u000B') || (chanChar > '\u000C')) &&
                                 ((chanChar < '\u000E') || (chanChar > '\u001F')) &&
                                 ((chanChar < '\u0021') || (chanChar > '\u002B')) &&
                                 ((chanChar < '\u002D') || (chanChar > '\u0039')) &&
                                 ((chanChar < '\u003B') || (chanChar > '\u00FF'))) {
                                     valid = false;
                                     break;
                             }
                             else {
                                 valid = true;
                             }
                         }
                         if (valid) success = true;
            }
        }
        else success = false;
        return success;
    }

}
