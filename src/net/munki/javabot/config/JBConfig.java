/*
 * Config.java
 *
 * Created on 29 July 2002, 18:33
 */

package net.munki.javabot.config;

import net.munki.javabot.exception.JBConfigurationException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/** Reads and writes properties data for JavaBot. */
public class JBConfig {
    
    private JBConfig() {
    }
    
    /** Returns a default set of properties.
     * @return The default properties.
     */    
    public static Properties getDefaultProperties() {
        Properties defaultProps = new Properties();
        defaultProps.put(JBData.PROP_SERVER, JBData.DEFAULT_SERVER);
        defaultProps.put(JBData.PROP_PORT, JBData.DEFAULT_PORT);
        defaultProps.put(JBData.PROP_NICKNAMES, JBData.DEFAULT_NICKNAMES);
        defaultProps.put(JBData.PROP_USERNAME, JBData.DEFAULT_USERNAME);
        defaultProps.put(JBData.PROP_REALNAME, JBData.DEFAULT_REALNAME);
        defaultProps.put(JBData.PROP_CHANNELS, JBData.DEFAULT_CHANNELS);
        defaultProps.put(JBData.PROP_BEANSHELL, JBData.DEFAULT_BEANSHELL);
        defaultProps.put(JBData.PROP_JYTHON, JBData.DEFAULT_JYTHON);
        defaultProps.put(JBData.PROP_JACL, JBData.DEFAULT_JACL);
        defaultProps.put(JBData.PROP_SECURITY_MANAGER, JBData.DEFAULT_SECURITY_MANAGER);
        return defaultProps;
    }
    
    /** Reads configuration settings into a Properties object.
     * @param defaultFile The file containing default properties.
     * @param configFile The file containing non-default properties.
     * @throws JBConfigurationException Thrown if there is a problem reading the properties.
     * @return A Properties object containing configuration data.
     */    
    public static Properties read(String defaultFile, String configFile) throws JBConfigurationException {
        Properties defaultProps = loadProperties(null, defaultFile);
        return loadProperties(defaultProps, configFile);
    }
    
    /** Reads configuration settings into a Properties object.
     * @param configFile The file containing the properties.
     * @throws JBConfigurationException Thrown if there is a problem reading the properties.
     * @return A Properties object containing configuration data.
     */    
    public static Properties read(String configFile) throws JBConfigurationException {
        return loadProperties(getDefaultProperties(), configFile);
    }
    
    /** Reads default configuration settings into a Properties object.
     * @return A Properties object containing configuration data.
     */    
    public static Properties read() {
        return getDefaultProperties();
    }
    
    private static Properties loadProperties(Properties defaultProps, String configFile) throws JBConfigurationException {
        Properties config;
        if (defaultProps == null) config = new Properties();
        else config = new Properties(defaultProps);
        try {
            FileInputStream in = new FileInputStream(configFile);
            config.load(in);
            in.close();
        }
        catch (IOException ioe) {
            throw new JBConfigurationException("Could not load configuration properties ...", ioe);
        }
        return config;
    }
    
    /** Writes config data back to a file.
     * @param config The properties object containing the configuration.
     * @param configFile The file to write to.
     * @throws JBConfigurationException Thrown if there is a problem reading the properties.
     */    
    public static void write(Properties config, String configFile) throws JBConfigurationException {
        try {
            FileOutputStream out = new FileOutputStream(configFile);
            config.store(out, "--- no comment ---");
            out.close();
        }
        catch (IOException ioe) {
            throw new JBConfigurationException("Could not save configuration properties ...", ioe);
        }
    }

}
