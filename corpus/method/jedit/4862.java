//}}}
//{{{ addPluginJAR() method
/**
	 * Loads the plugin JAR with the specified path. Some notes about this
	 * method:
	 *
	 * <ul>
	 * <li>Calling this at a time other than jEdit startup can have
	 * unpredictable results if the plugin has not been updated for the
	 * jEdit 4.2 plugin API.
	 * <li>You must make sure yourself the plugin is not already loaded.
	 * <li>After loading, you just make sure all the plugin's dependencies
	 * are satisified before activating the plugin, using the
	 * {@link PluginJAR#checkDependencies()} method.
	 * </ul>
	 *
	 * @param path The JAR file path
	 * @since jEdit 4.2pre1
	 */
public static void addPluginJAR(String path) {
    PluginJAR jar = new PluginJAR(new File(path));
    jars.addElement(jar);
    if (jar.init()) {
        String jarName = MiscUtilities.getFileName(path);
        jEdit.unsetProperty("plugin-blacklist." + jarName);
        jEdit.unsetProperty("plugin." + jarName + ".disabled");
        EditBus.send(new PluginUpdate(jar, PluginUpdate.LOADED, false));
        if (!isMainThread()) {
            EditBus.send(new DynamicMenuChanged("plugins"));
            initKeyBindings();
        }
    } else {
        jars.removeElement(jar);
        jar.uninit(false);
    }
}