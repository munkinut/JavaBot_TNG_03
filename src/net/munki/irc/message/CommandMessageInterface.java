/*
 * ServerMessageInterface.java
 *
 * Created on 24 July 2002, 13:44
 */

package net.munki.irc.message;

public interface CommandMessageInterface extends GenericMessageInterface {

    /**
     * @return
     */    
    public String getMessageType();
    
}

