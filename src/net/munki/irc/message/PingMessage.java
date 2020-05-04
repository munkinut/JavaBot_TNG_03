/*
 * PingMessage.java
 *
 */

package net.munki.irc.message;

import net.munki.irc.protocol.rfc2812.MessageNames;

public class PingMessage implements CommandMessageInterface {
    
    private String parameters;

    /**
     * @param parameters
     */    
    public PingMessage(String parameters) {
        this.parameters = parameters;
    }

    /**
     * @return
     */    
    public String getMessageType() {
        return MessageNames.PING;
    }

    /**
     * @return
     */    
    public String getParameters() {
        return parameters;
    }
}
