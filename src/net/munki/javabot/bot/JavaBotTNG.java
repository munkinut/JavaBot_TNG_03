/*
 * JavaBotTNG.java
 *
 * Created on 17 July 2002, 12:53
 */

package net.munki.javabot.bot;

import net.munki.irc.bot.BotCore;
import net.munki.javabot.config.JBData;
import net.munki.javabot.exception.*;
import net.munki.util.string.StringTool;

import java.util.Properties;
import java.util.logging.Logger;

/** JavaBot The Next Generation */
public class JavaBotTNG {
    
    private String server = null;
    private int port = 0;
    private String[] nicks = null;
    private String username = null;
    private String realname = null;
    private String[] channels = null;
    
    boolean enableSecurityManager = false;
    boolean enableBeanshell = false;
    boolean enableJython = false;
    boolean enableJacl = false;
    
    private Logger logger;
    
    /** Creates a new JavaBot using values passed to it in a properties file.
     * @param config The properties.
     * @throws JBConfigurationException Thrown if there is a problem parsing the properties file.
     */    
    public JavaBotTNG(Properties config, boolean useSecurityManager,
                      boolean useBeanshell, boolean usePython, boolean useTcl)
          throws JBConfigurationException {
        initLogger();
        if (config == null) {
            throw new JBConfigurationException("Configuration was null ...");
        }
        else {
            this.parseConfig(config);
        }
        initSecurity(useSecurityManager);
        initBeanshell(useBeanshell);
        initPython(usePython);
        initTcl(useTcl);
        startSecurityManager();
    }
    
    private void initLogger() {
        logger = Logger.getLogger(this.getClass().getName());
    }
    
    private void initSecurity(boolean useSecurityManager) {
        enableSecurityManager = useSecurityManager;
    }
    
    private void initBeanshell(boolean useBeanshell) {
        enableBeanshell = useBeanshell;
    }
    
    private void initPython(boolean usePython) {
        enableJython = usePython;
    }

    private void initTcl(boolean useTcl) {
        enableJacl = useTcl;
    }
    
    private void startSecurityManager() {
        if (enableSecurityManager) {
            System.setSecurityManager(new net.munki.javabot.security.JBSecurityManager());
        }
    }
    
    private void parseConfig(Properties config) throws JBConfigurationException {
        try {
            server = config.getProperty(JBData.PROP_SERVER, JBData.DEFAULT_SERVER);
            if ((server == null) || (server.equals(""))) {
                throw new JBInvalidServerException("Server name is invalid ...");
            }
            nicks = StringTool.uncat(config.getProperty(JBData.PROP_NICKNAMES,
		JBData.DEFAULT_NICKNAMES));
            username = config.getProperty(JBData.PROP_USERNAME, JBData.DEFAULT_USERNAME);
            if ((username == null) || (username.equals(""))) {
                throw new JBInvalidUsernameException("Username was invalid ...");
            }
            realname = config.getProperty(JBData.PROP_REALNAME, JBData.DEFAULT_REALNAME);
            if ((realname == null) || (realname.equals(""))) {
                throw new JBInvalidRealnameException("Realname was invalid ...");
            }
            channels = StringTool.uncat(config.getProperty(JBData.PROP_CHANNELS, JBData.DEFAULT_CHANNELS));
            if ((channels == null) || (channels.equals(""))) {
                throw new JBInvalidChannelException("Channels were invalid ...");
            }
            port = Integer.parseInt(config.getProperty(JBData.PROP_PORT, JBData.DEFAULT_PORT));
            if ((port < 1) || (port > 65535)) {
                throw new JBInvalidPortException("Port number is out of range ...");
            }
            enableSecurityManager = Boolean.valueOf(config.getProperty(JBData.PROP_SECURITY_MANAGER, JBData.DEFAULT_SECURITY_MANAGER)).booleanValue();
            enableBeanshell = Boolean.valueOf(config.getProperty(JBData.PROP_BEANSHELL, JBData.DEFAULT_BEANSHELL)).booleanValue();
            enableJython = Boolean.valueOf(config.getProperty(JBData.PROP_JYTHON, JBData.DEFAULT_JYTHON)).booleanValue();
            enableJacl = Boolean.valueOf(config.getProperty(JBData.PROP_JACL, JBData.DEFAULT_JACL)).booleanValue();
        }
        catch (NumberFormatException nfe) {
            throw new JBConfigurationException("Configuration invalid ...", nfe);
        }
        catch (JBInvalidPortException jbpe) {
            throw new JBConfigurationException("Configuration invalid ...", jbpe);
        }
        catch (JBInvalidServerException jbse) {
            throw new JBConfigurationException("Configuration invalid ...", jbse);
        } catch (JBInvalidRealnameException jbre) {
            throw new JBConfigurationException("Configuration invalid ...", jbre);
        }
        catch (JBInvalidUsernameException jbue) {
            throw new JBConfigurationException("Configuration invalid ...", jbue);
        }
        catch (JBInvalidChannelException jbce) {
            throw new JBConfigurationException("Configuration invalid ...", jbce);
        }
    }
    
    /** Starts the bot. */    
    public void start() {
        BotCore bot = new BotCore(server, port, nicks, username, realname,
            channels, enableBeanshell, enableJython, enableJacl);
        if (bot.connect()) {
            logger.fine("Connection established ...");
            if (bot.signOn()) {
                logger.fine("Sign on completed ...");
            }
            else {
                logger.warning("Sign on failed ...");
                bot.kill();
            }
        }
        else {
            logger.warning("Connection failed ...");
            bot.kill();
        }
    }
    
}
