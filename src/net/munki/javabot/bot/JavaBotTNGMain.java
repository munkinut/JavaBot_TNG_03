/*
 * JavaBotTNGMain.java
 *
 * Created on 05 March 2003, 13:24
 */

package net.munki.javabot.bot;

import jargs.gnu.CmdLineParser;
import net.munki.javabot.config.JBConfig;
import net.munki.javabot.config.JBData;
import net.munki.javabot.exception.JBConfigurationException;

import java.util.Properties;

/** Starter class for JavaBotTNG.
 * @author Warren Milburn
 */
public class JavaBotTNGMain {
    
    /** Constructs a properties file from command line data or using defaults,
     * then passes it to the bot.
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        
        Properties config = null;
        boolean securityManager = false;
        boolean beanshell = true;
        boolean python = true;
        boolean tcl = true;

        CmdLineParser parser = new CmdLineParser();
        CmdLineParser.Option configOpt = parser.addStringOption('c', "config");
        CmdLineParser.Option helpOpt = parser.addBooleanOption('h', "help");
        CmdLineParser.Option noSecurityOpt = parser.addBooleanOption('s', "without-security-manager");
        CmdLineParser.Option noBeanshellOpt = parser.addBooleanOption('b', "without-beanshell");
        CmdLineParser.Option noPythonOpt = parser.addBooleanOption('j', "without-python");
        CmdLineParser.Option noTclOpt = parser.addBooleanOption('t', "without-tcl");
        
        try {
            parser.parse(args);
        }
        catch ( CmdLineParser.OptionException e ) {
            error(e.getMessage());
            usage();
            System.exit(1);
        }

        Boolean helpValue = (Boolean)parser.getOptionValue(helpOpt);
        if (helpValue != null)
            if (helpValue) {
                usage();
                System.exit(0);
            }
        
        String configValue = (String)parser.getOptionValue(configOpt);
        if (configValue == null) {
            config = JBConfig.read();
        }
        else {
            try {
                config = JBConfig.read(configValue);
            }
            catch (JBConfigurationException ioe) {
                error(ioe.getMessage());
                System.exit(1);
            }
        }
        
        Boolean noSecurityValue = (Boolean)parser.getOptionValue(noSecurityOpt);
        if (noSecurityValue != null) {
            securityManager = !noSecurityValue;
        }
        
        Boolean noBeanshellValue = (Boolean)parser.getOptionValue(noBeanshellOpt);
        if (noBeanshellValue != null) {
            beanshell = !noBeanshellValue;
        }
        
        Boolean noPythonValue = (Boolean)parser.getOptionValue(noPythonOpt);
        if (noPythonValue != null) {
            python = !noPythonValue;
        }
        
        Boolean noTclValue = (Boolean)parser.getOptionValue(noTclOpt);
        if (noTclValue != null) {
            tcl = !noTclValue;
        }
        
        try {
            JavaBotTNG jbtng = new JavaBotTNG(
                config,
                securityManager,
                beanshell,
                python,
                tcl
            );
            jbtng.start();
        }
        catch (JBConfigurationException jbce) {
            error(jbce.getMessage());
        }
    }
    
    private static void usage() {
        System.out.print(JBData.NAME);
        System.out.print(" ");
        System.out.print(JBData.VERSION);
        System.out.println(" Usage : \n");
        System.out.println(JBData.USAGE_1);
        System.out.println(JBData.USAGE_2);
        System.out.println(JBData.USAGE_3);
        System.out.println(JBData.USAGE_4);
        System.out.println(JBData.USAGE_5);
        System.out.println(JBData.USAGE_6);
        System.out.println(JBData.USAGE_7);
        System.out.println(JBData.USAGE_8);
        System.out.println(JBData.USAGE_9);
        System.out.println();
    }
    
    private static void error(String errorMessage) {
        System.err.print(JBData.NAME);
        System.err.print(" ");
        System.err.print(JBData.VERSION);
        System.err.println(" Error : \n");
        System.err.print("    ");
        System.err.println(errorMessage);
        System.err.println();
    }
    
}
