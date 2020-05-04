package net.munki.javabot.config;

/** Contains default data. */
public class JBData {
    
    private JBData() {}
 
    public static final String NAME = "JavaBot TNG";
    public static final String VERSION = "3.0";
    public static final String USAGE_1 = "    java -jar jbTNG";
    public static final String USAGE_2 = "    java -jar jbTNG <options>";
    public static final String USAGE_3 = "      Options :";
    public static final String USAGE_4 = "        -h (--help)";
    public static final String USAGE_5 = "        -c (--config) <config-file>";
    public static final String USAGE_6 = "        -s (--without-security-manager)";
    public static final String USAGE_7 = "        -b (--without-beanshell)";
    public static final String USAGE_8 = "        -p (--without-python)";
    public static final String USAGE_9 = "        -t (--without-tcl)";
    public static final String START_MESSAGE = "Starting...";
    public static final String CONFIG_MESSAGE = "Parsing configuration data...";
    public static final String CONFIG_FAILED = "Configuration failed...";
    public static final String INIT_MESSAGE = "Initializing...";
    public static final String CONNECT_MESSAGE = "Connecting...";
    public static final String INIT_FAILED = "Initialization failed...";
    public static final String CONNECT_FAILED = "Connection failed...";
    public static final String INIT_SUCCEEDED = "Initialization succeeded...";
    public static final String CONNECT_SUCCEEDED = "Connection succeeded...";
    public static final String PROP_SERVER = "server";
    public static final String PROP_PORT = "port";
    public static final String PROP_NICKNAMES = "nicknames";
    public static final String PROP_REALNAME = "realname";
    public static final String PROP_USERNAME = "username";
    public static final String PROP_CHANNELS = "channels";
    public static final String PROP_BEANSHELL = "beanshell";
    public static final String PROP_JYTHON = "jython";
    public static final String PROP_JACL = "jacl";
    public static final String PROP_SECURITY_MANAGER = "security-manager";
    public static final String DEFAULT_SERVER = "eu.ircnet.org";
    public static final String DEFAULT_PORT = "6665";
    public static final String DEFAULT_NICKNAMES = "periotu";
    public static final String DEFAULT_USERNAME = "periotu";
    public static final String DEFAULT_REALNAME = "periotu";
    public static final String DEFAULT_CHANNELS = "#lkdjfghlkj";
    public static final String DEFAULT_BEANSHELL = "true";
    public static final String DEFAULT_JYTHON = "true";
    public static final String DEFAULT_JACL = "true";
    public static final String DEFAULT_SECURITY_MANAGER = "true";
}