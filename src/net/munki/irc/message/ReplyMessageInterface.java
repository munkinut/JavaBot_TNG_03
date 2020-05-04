/*
 * ReplyMessageInterface.java
 *
 * Created on 24 July 2002, 13:22
 */

package net.munki.irc.message;

public interface ReplyMessageInterface extends GenericMessageInterface {

    /**
     * @return
     */    
    public String getMessageType();
    
}

