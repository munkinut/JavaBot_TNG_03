/*
 * JBSecurityManager.java
 *
 * Created on 04 October 2003, 14:29
 */

package net.munki.javabot.security;

import net.munki.util.string.StringTool;

import javax.net.ssl.SSLPermission;
import javax.security.auth.AuthPermission;
import javax.security.auth.PrivateCredentialPermission;
import javax.security.auth.kerberos.DelegationPermission;
import javax.security.auth.kerberos.ServicePermission;
import javax.sound.sampled.AudioPermission;
import java.awt.*;
import java.io.*;
import java.lang.reflect.ReflectPermission;
import java.net.NetPermission;
import java.net.SocketPermission;
import java.security.Permission;
import java.security.SecurityPermission;
import java.security.UnresolvedPermission;
import java.sql.SQLPermission;
import java.util.PropertyPermission;
import java.util.logging.Logger;
import java.util.logging.LoggingPermission;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author  Warren Milburn
 */
public class JBSecurityManager extends SecurityManager {
    
    private static final String HOSTS_ALLOW = StringTool.cat(new String[] {
        "config",
        File.separator,
        "hosts.allow"
    });
    private static final String SERVERS_ALLOW = StringTool.cat(new String[] {
        "config",
        File.separator,
        "servers.allow"
    });
    private static final String LISTENERS_ALLOW = StringTool.cat(new String[] {
        "config",
        File.separator,
        "listeners.allow"
    });

    private Logger logger;
    /** Creates a new instance of JBSecurityManager */
    public JBSecurityManager() {
        logger = Logger.getLogger(this.getClass().getName());
    }
    
    public void checkAccept(String str, int param) {
        if (!isAcceptAllowed(str)) throw new SecurityException(StringTool.cat(new String[] {
            "Access denied to ",
            str,
            "."
        }));
    }
    
    public void checkAccess(Thread thread) {
    }
    
    public void checkAccess(ThreadGroup threadGroup) {
    }
    
    public void checkAwtEventQueueAccess() {
    }
    
    public void checkConnect(String str, int param) {
        if (!isConnectAllowed(str, param)) throw new SecurityException(StringTool.cat(new String[] {
            "Access denied for connection to ",
            str,
            " on port ",
            Integer.toString(param),
            "."
        }));
    }
    
    public void checkConnect(String str, int param, Object obj) {
        if (!isConnectAllowed(str, param)) throw new SecurityException(StringTool.cat(new String[] {
            "Access denied for connection to ",
            str,
            " on port ",
            Integer.toString(param),
            "."
        }));
    }
    
    public void checkCreateClassLoader() {
    }
    
    public void checkDelete(String str) {
        super.checkDelete(str);
    }
    
    public void checkExec(String str) {
    }
    
    public void checkExit(int param) {
    }
    
    public void checkLink(String str) {
    }
    
    public void checkListen(int param) {
        String sparam = Integer.toString(param);
        if (!isListenAllowed(sparam)) throw new SecurityException(StringTool.cat(new String[] {
            "Access denied to listen port ",
            sparam,
            "."
        }));
    }
    
    public void checkMemberAccess(Class clazz, int param) {
    }
    
    public void checkMulticast(java.net.InetAddress inetAddress) {
    }
    
    public void checkPackageAccess(String str) {
    }
    
    public void checkPackageDefinition(String str) {
    }
    
    public void checkPermission(Permission perm) {
        if (perm instanceof SecurityPermission) handleSecurityPermission(perm);
        else if (perm instanceof UnresolvedPermission) handleUnresolvedPermission(perm);
        else if (perm instanceof AWTPermission) handleAWTPermission(perm);
        else if (perm instanceof FilePermission) handleFilePermission(perm);
        else if (perm instanceof SerializablePermission) handleSerializablePermission(perm);
        else if (perm instanceof ReflectPermission) handleReflectPermission(perm);
        else if (perm instanceof RuntimePermission) handleRuntimePermission(perm);
        else if (perm instanceof NetPermission) handleNetPermission(perm);
        else if (perm instanceof SocketPermission) handleSocketPermission(perm);
        else if (perm instanceof SQLPermission) handleSQLPermission(perm);
        else if (perm instanceof PropertyPermission) handlePropertyPermission(perm);
        else if (perm instanceof LoggingPermission) handleLoggingPermission(perm);
        else if (perm instanceof SSLPermission) handleSSLPermission(perm);
        else if (perm instanceof AuthPermission) handleAuthPermission(perm);
        else if (perm instanceof PrivateCredentialPermission) handlePrivateCredentialPermission(perm);
        else if (perm instanceof DelegationPermission) handleDelegationPermission(perm);
        else if (perm instanceof ServicePermission) handleServicePermission(perm);
        else if (perm instanceof AudioPermission) handleAudioPermission(perm);
        else throw new SecurityException("Unrecognised Permission requested.");
    }
    
    public void checkPrintJobAccess(Permission perm) {
    }
    
    public void checkPropertiesAccess(Permission perm) {
    }
    
    public void checkPropertyAccess(String str) {
    }
    
    public void checkRead(FileDescriptor fileDescriptor) {
    }

    public void checkRead(String str) {
    }

    public void checkRead(String str, Object obj) {
    }

    public void checkSecurityAccess(String str) {
    }

    public void checkSetFactory() {
    }

    public void checkSystemClipboardAccess() {
    }

    public boolean checkTopLevelWindow(Object obj) {
        // return super.checkTopLevelWindow(obj);
    	// TODO: above is deprecated, see advice.
    	return true;
    }

    public void checkWrite(FileDescriptor fileDescriptor) {
    }

    public void checkWrite(String str) {
        if (!isWriteAllowed(str)) throw new SecurityException(StringTool.cat(new String[] {
            "Write access denied to ",
            str,
            "."
        }));
    }

    private void handleSecurityPermission(Permission perm) {
        if (perm.getName().equals("createAccessControlContext")) {
            //
        }
        else if (perm.getName().equals("getDomainCombiner")) {
            //
        }
        else if (perm.getName().equals("getPolicy")) {
            //
        }
        else if (perm.getName().equals("setPolicy")) {
            throw new SecurityException("setPolicy : That is not allowed.");
        }
        else if (perm.getName().startsWith("getProperty")) {
            //
        }
        else if (perm.getName().startsWith("setProperty")) {
            //
        }
        else if (perm.getName().startsWith("insertProvider")) {
            //
        }
        else if (perm.getName().startsWith("removeProvider")) {
            //
        }
        else if (perm.getName().equals("setSystemScope")) {
            //
        }
        else if (perm.getName().equals("setIdentityPublicKey")) {
            //
        }
        else if (perm.getName().equals("setIdentityInfo")) {
            //
        }
        else if (perm.getName().equals("addIdentityCertificate")) {
            //
        }
        else if (perm.getName().equals("removeIdentityCertificate")) {
            //
        }
        else if (perm.getName().equals("printIdentity")) {
            //
        }
        else if (perm.getName().startsWith("clearProviderProperties")) {
            //
        }
        else if (perm.getName().startsWith("putProviderProperty")) {
            //
        }
        else if (perm.getName().startsWith("removeProviderProperty")) {
            //
        }
        else if (perm.getName().equals("getSignerPrivateKey")) {
            //
        }
        else if (perm.getName().equals("setSignerKeyPair")) {
            //
        }
        else throw new SecurityException("Unrecognised Permission requested.");
    }

    private void handleUnresolvedPermission(Permission perm) {
        //
    }

    private void handleAWTPermission(Permission perm) {
        if (perm.getName().equals("accessClipboard")) {
            //
        }
        else if (perm.getName().equals("accessEventQueue")) {
            //
        }
        else if (perm.getName().equals("createRobots")) {
            //
        }
        else if (perm.getName().equals("listenToAllAWTEvents")) {
            //
        }
        else if (perm.getName().equals("readDisplayPixels")) {
            //
        }
        else if (perm.getName().equals("showWindowWithoutWarningBanner")) {
            //
        }
        else throw new SecurityException("Unrecognised Permission requested.");
    }

    private void handleFilePermission(Permission perm) {
    }

    private void handleSerializablePermission(Permission perm) {
        if (perm.getName().equals("enableSubclassImplementation")) {
            //
        }
        else if (perm.getName().equals("enableSubstitution")) {
            throw new SecurityException("enableSubstitution : That is not allowed.");
        }
        else throw new SecurityException("Unrecognised Permission requested.");
    }

    private void handleReflectPermission(Permission perm) {
        if (perm.getName().equals("suppressAccessChecks")) {
            //
        }
        else throw new SecurityException("Unrecognised Permission requested.");
    }

    private void handleRuntimePermission(Permission perm) {
        if (perm.getName().equals("createClassLoader")) {
            throw new SecurityException("createClassLoader : That is not allowed.");
        }
        else if (perm.getName().equals("getClassLoader")) {
            throw new SecurityException("getClassLoader : That is not allowed.");
        }
        else if (perm.getName().equals("setContextClassLoader")) {
            //
        }
        else if (perm.getName().equals("setSecurityManager")) {
            throw new SecurityException("setSecurityManager : That is not allowed.");
        }
        else if (perm.getName().equals("createSecurityManager")) {
            throw new SecurityException("createSecurityManager : That is not allowed.");
        }
        else if (perm.getName().equals("exitVM")) {
            //
        }
        else if (perm.getName().equals("shutdownHooks")) {
            //
        }
        else if (perm.getName().equals("setFactory")) {
            throw new SecurityException("setFactory : That is not allowed.");
        }
        else if (perm.getName().equals("setIO")) {
            //
        }
        else if (perm.getName().equals("modifyThread")) {
            //
        }
        else if (perm.getName().equals("stopThread")) {
            //
        }
        else if (perm.getName().equals("modifyThreadGroup")) {
            //
        }
        else if (perm.getName().equals("getProtectionDomain")) {
            //
        }
        else if (perm.getName().equals("readFileDescriptor")) {
            //
        }
        else if (perm.getName().equals("writeFileDescriptor")) {
            //
        }
        else if (perm.getName().startsWith("loadLibrary")) {
            //
        }
        else if (perm.getName().startsWith("accessClassInPackage")) {
            //
        }
        else if (perm.getName().startsWith("defineClassInPackage")) {
            //
        }
        else if (perm.getName().equals("accessDeclaredMembers")) {
            throw new SecurityException("accessDeclaredMembers : That is not allowed.");
        }
        else if (perm.getName().equals("queuePrintJob")) {
            //
        }
        else if (perm.getName().equals("selectorProvider")) {
            //
        }
        else if (perm.getName().equals("charsetProvider")) {
            //
        }
        else throw new SecurityException("Unrecognised Permission requested.");
    }

    private void handleNetPermission(Permission perm) {
        if (perm.getName().equals("setDefaultAuthenticator")) {
            //
        }
        else if (perm.getName().equals("requestPasswordAuthentication")) {
            //
        }
        else if (perm.getName().equals("specifyStreamHandler")) {
            //
        }
        else throw new SecurityException("Unrecognised Permission requested.");
    }

    private void handleSocketPermission(Permission perm) {
    }

    private void handleSQLPermission(Permission perm) {
        if (perm.getName().equals("setLog")) {
            //
        }
        else throw new SecurityException("Unrecognised Permission requested.");
    }

    private void handlePropertyPermission(Permission perm) {
    }

    private void handleLoggingPermission(Permission perm) {
    }

    private void handleSSLPermission(Permission perm) {
        if (perm.getName().equals("setHostnameVerifier")) {
            //
        }
        else if (perm.getName().equals("getSSLSessionContext")) {
            //
        }
        else throw new SecurityException("Unrecognised Permission requested.");
    }

    private void handleAuthPermission(Permission perm) {
        if (perm.getName().equals("doAs")) {
            //
        }
        else if (perm.getName().equals("doAsPrivileged")) {
            //
        }
        else if (perm.getName().equals("getSubject")) {
            //
        }
        else if (perm.getName().equals("getSubjectFromDomainCombiner")) {
            //
        }
        else if (perm.getName().equals("setReadOnly")) {
            //
        }
        else if (perm.getName().equals("modifyPrincipals")) {
            //
        }
        else if (perm.getName().equals("modifyPublicCredentials")) {
            //
        }
        else if (perm.getName().equals("modifyPrivateCredentials")) {
            //
        }
        else if (perm.getName().equals("refreshCredential")) {
            //
        }
        else if (perm.getName().equals("destroyCredential")) {
            //
        }
        else if (perm.getName().startsWith("createLoginContext")) {
            //
        }
        else if (perm.getName().equals("getLoginConfiguration")) {
            //
        }
        else if (perm.getName().equals("setLoginConfiguration")) {
            //
        }
        else if (perm.getName().equals("refreshLoginConfiguration")) {
            //
        }
        else throw new SecurityException("Unrecognised Permission requested.");
    }

    private void handlePrivateCredentialPermission(Permission perm) {
    }

    private void handleDelegationPermission(Permission perm) {
    }

    private void handleServicePermission(Permission perm) {
    }

    private void handleAudioPermission(Permission perm) {
        if (perm.getName().equals("play")) {
            //
        }
        else if (perm.getName().equals("record")) {
            //
        }
        else throw new SecurityException("Unrecognised Permission requested.");
    }

    private boolean isWriteAllowed(String file) {
        boolean returnValue = false;
        if ( (file.indexOf("cachedir") > -1)
          || (file.indexOf("packages") > -1)
          || (file.endsWith(".idx"))
          || (file.endsWith(".pkc"))) {
            logger.finer(StringTool.cat(new String[] {
                "Write allowed for ",
                file,
                " ..."
            }));
            returnValue = true;
        }
        else logger.warning(StringTool.cat(new String[] {
            "Write disallowed for ",
            file,
            " ..."
        }));
        return returnValue;
    }

    private boolean isListenAllowed(String port) {
        boolean returnValue = false;
        File file = null;
        try {
            file = new File(LISTENERS_ALLOW);
            BufferedReader br = new BufferedReader(new FileReader(file));
            Pattern portPattern = Pattern.compile(port);
            Matcher portMatcher;
            String input;
            int line = 0;
            while ((input = br.readLine()) != null) {
                line++;
                portMatcher = portPattern.matcher(input);
                if (portMatcher.find()) {
                    returnValue = true;
                    logger.finer(StringTool.cat(new String[] {
                        "Port found in ",
                        LISTENERS_ALLOW,
                        " at line ",
                        Integer.toString(line),
                        " ..."
                    }));
                }
                else {
                    logger.finer(StringTool.cat(new String[] {
                        "Port not found in ",
                        LISTENERS_ALLOW,
                        " ..."
                    }));
                }
            }
            br.close();
        }
        catch (IOException ioe) {
            if (ioe instanceof FileNotFoundException) {
                returnValue = false;
                logger.warning(StringTool.cat(new String[] {
                    LISTENERS_ALLOW,
                    " file could not be found. Message was ",
                    ioe.getMessage(),
                    " ..."
                }));
            }
            else {
                returnValue = false;
                logger.warning(StringTool.cat(new String[] {
                    "Error reading ",
                    LISTENERS_ALLOW,
                    " file. Message was ",
                    ioe.getMessage(),
                    " ..."
                }));
            }
        }
        return returnValue;
    }

    private boolean isConnectAllowed(String host, int port) {
        boolean returnValue = false;
        if (host != null) {
            File file = null;
            try {
                file = new File(SERVERS_ALLOW);
                BufferedReader br = new BufferedReader(new FileReader(file));
                Pattern hostPattern = Pattern.compile(host);
                Matcher hostMatcher;
                String input;
                int line = 0;
                while ((input = br.readLine()) != null) {
                    line++;
                    hostMatcher = hostPattern.matcher(input);
                    if (hostMatcher.find()) {
                        Pattern portPattern = Pattern.compile(Integer.toString(port));
                        Matcher portMatcher = portPattern.matcher(input);
                        if ((port == -1) || (portMatcher.find())) {
                            returnValue = true;
                            logger.finer(StringTool.cat(new String[] {
                                "Port found in ",
                                SERVERS_ALLOW,
                                " at line ",
                                Integer.toString(line),
                                " ..."
                            }));
                        }
                        else {
                            logger.finer(StringTool.cat(new String[] {
                                "Port not found in ",
                                SERVERS_ALLOW,
                                " ..."
                            }));
                        }
                        logger.finer(StringTool.cat(new String[] {
                            "Server found in ",
                            SERVERS_ALLOW,
                            " at line ",
                            Integer.toString(line),
                            " ..."
                        }));
                    }
                    else {
                        logger.finer(StringTool.cat(new String[] {
                            "Server not found in ",
                            SERVERS_ALLOW,
                            " ..."
                        }));
                    }
                }
                br.close();
            }
            catch (IOException ioe) {
                if (ioe instanceof FileNotFoundException) {
                    returnValue = false;
                    logger.warning(StringTool.cat(new String[] {
                        SERVERS_ALLOW,
                        " file could not be found. Message was ",
                        ioe.getMessage(),
                        " ..."
                    }));
                }
                else {
                    returnValue = false;
                    logger.warning(StringTool.cat(new String[] {
                        "Error reading ",
                        SERVERS_ALLOW,
                        " file. Message was ",
                        ioe.getMessage(),
                        " ..."
                    }));
                }
            }
        }
        return returnValue;
    }

    private boolean isAcceptAllowed(String client) {
        boolean returnValue = false;
        if (client != null) {
            File file = null;
            try {
                file = new File(HOSTS_ALLOW);
                BufferedReader br = new BufferedReader(new FileReader(file));
                Pattern hostPattern = Pattern.compile(client);
                Matcher hostMatcher;
                String input;
                int line = 0;
                while ((input = br.readLine()) != null) {
                    line++;
                    hostMatcher = hostPattern.matcher(input);
                    if (hostMatcher.find()) {
                        returnValue = true;
                        logger.finer(StringTool.cat(new String[] {
                            "Host found in ",
                            HOSTS_ALLOW,
                            " at line ",
                            Integer.toString(line),
                            " ..."
                        }));
                    }
                    else {
                        logger.finer(StringTool.cat(new String[] {
                            "Host not found in ",
                            HOSTS_ALLOW,
                            " ..."
                        }));
                    }
                }
                br.close();
            }
            catch (IOException ioe) {
                if (ioe instanceof FileNotFoundException) {
                    returnValue = false;
                    logger.warning(StringTool.cat(new String[] {
                        HOSTS_ALLOW,
                        " file could not be found. Message was ",
                        ioe.getMessage(),
                        " ..."
                    }));
                }
                else {
                    returnValue = false;
                    logger.warning(StringTool.cat(new String[] {
                        "Error reading ",
                        HOSTS_ALLOW,
                        " file. Message was ",
                        ioe.getMessage(),
                        " ..."
                    }));
                }
            }
        }
        return returnValue;
    }
    
}
