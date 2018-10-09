//}}}
//{{{ isToolsJarAvailable() method
/**
	 * If on JDK 1.2 or higher, make sure that tools.jar is available.
	 * This method should be called by plugins requiring the classes
	 * in this library.
	 * <p>
	 * tools.jar is searched for in the following places:
	 * <ol>
	 *   <li>the classpath that was used when jEdit was started,
	 *   <li>jEdit's jars folder in the user's home,
	 *   <li>jEdit's system jars folder,
	 *   <li><i>java.home</i>/lib/. In this case, tools.jar is added to
	 *       jEdit's list of known jars using jEdit.addPluginJAR(),
	 *       so that it gets loaded through JARClassLoader.
	 * </ol><p>
	 *
	 * On older JDK's this method does not perform any checks, and returns
	 * <code>true</code> (even though there is no tools.jar).
	 *
	 * @return <code>false</code> if and only if on JDK 1.2 and tools.jar
	 *    could not be found. In this case it prints some warnings on Log,
	 *    too, about the places where it was searched for.
	 * @since jEdit 3.2.2
	 */
public static boolean isToolsJarAvailable() {
    Log.log(Log.DEBUG, MiscUtilities.class, "Searching for tools.jar...");
    Collection<String> paths = new LinkedList<String>();
    //{{{ 1. Check whether tools.jar is in the system classpath:
    paths.add("System classpath: " + System.getProperty("java.class.path"));
    try {
        // com.sun.tools.javac.Main must be there:
        try {
            Class.forName("sun.tools.javac.Main");
        } catch (ClassNotFoundException e1) {
            Class.forName("com.sun.tools.javac.Main");
        }
        Log.log(Log.DEBUG, MiscUtilities.class, "- is in classpath. Fine.");
        return true;
    } catch (ClassNotFoundException e) {
    }
    //{{{ 2. Check whether it is in the jEdit user settings jars folder:
    String settingsDir = jEdit.getSettingsDirectory();
    if (settingsDir != null) {
        String toolsPath = constructPath(settingsDir, "jars", "tools.jar");
        paths.add(toolsPath);
        if (new File(toolsPath).exists()) {
            Log.log(Log.DEBUG, MiscUtilities.class, "- is in the user's jars folder. Fine.");
            // jEdit will load it automatically
            return true;
        }
    //}}}
    }
    //{{{ 3. Check whether it is in jEdit's system jars folder:
    String jEditDir = jEdit.getJEditHome();
    if (jEditDir != null) {
        String toolsPath = constructPath(jEditDir, "jars", "tools.jar");
        paths.add(toolsPath);
        if (new File(toolsPath).exists()) {
            Log.log(Log.DEBUG, MiscUtilities.class, "- is in jEdit's system jars folder. Fine.");
            // jEdit will load it automatically
            return true;
        }
    //}}}
    }
    //{{{ 4. Check whether it is in <java.home>/lib:
    String toolsPath = System.getProperty("java.home");
    if (toolsPath.toLowerCase().endsWith(File.separator + "jre"))
        toolsPath = toolsPath.substring(0, toolsPath.length() - 4);
    toolsPath = constructPath(toolsPath, "lib", "tools.jar");
    paths.add(toolsPath);
    if (!new File(toolsPath).exists()) {
        Log.log(Log.WARNING, MiscUtilities.class, "Could not find tools.jar.\n" + "I checked the following locations:\n" + paths.toString());
        return false;
    //}}}
    }
    //{{{ Load it, if not yet done:
    PluginJAR jar = jEdit.getPluginJAR(toolsPath);
    if (jar == null) {
        Log.log(Log.DEBUG, MiscUtilities.class, "- adding " + toolsPath + " to jEdit plugins.");
        jEdit.addPluginJAR(toolsPath);
    } else
        Log.log(Log.DEBUG, MiscUtilities.class, "- has been loaded before.");
    return true;
}