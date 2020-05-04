/*
 * ScriptTool.java
 *
 * Created on 27 July 2002, 13:26
 */

package net.munki.irc.util;

import net.munki.util.string.StringTool;

/** Provides tools for manipulating script files. */
public class ScriptTool {

    private ScriptTool() {
    }

    /** Provides the correct path to script files based on the name passed by the user.
     * @return A String representing the path to the script.
     * @param command The name of the script.
     */    
    public static String pathToBeanshellScript(String command) {
        String fs = java.io.File.separator;
        String[] toCat = {"scripts",fs,command,".bsh"};
        return StringTool.cat(toCat);
    }

    /** Provides the correct path to script files based on the name passed by the user.
     * @return A String representing the path to the script.
     * @param command The name of the script.
     */    
    public static String pathToJaclScript(String command) {
        String fs = java.io.File.separator;
        String[] toCat = {"scripts",fs,command,".tcl"};
        return StringTool.cat(toCat);
    }

    /** Provides the correct path to script files based on the name passed by the user.
     * @return A String representing the path to the script.
     * @param command The name of the script.
     */    
    public static String pathToJythonScript(String command) {
        String fs = java.io.File.separator;
        String[] toCat = {"scripts",fs,command,".py"};
        return StringTool.cat(toCat);
    }
}
