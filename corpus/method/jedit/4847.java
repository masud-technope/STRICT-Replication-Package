//}}}
//{{{ removePluginJAR() method
/**
	 * Unloads the given plugin JAR with the specified path. Note that
	 * calling this at a time other than jEdit shutdown can have
	 * unpredictable results if the plugin has not been updated for the
	 * jEdit 4.2 plugin API.
	 *
	 * @param jar The <code>PluginJAR</code> instance
	 * @param exit Set to true if jEdit is exiting; enables some
	 * shortcuts so the editor can close faster.
	 * @since jEdit 4.2pre1
	 */
public static void removePluginJAR(PluginJAR jar, boolean exit) {
    if (exit) {
        jar.uninit(true);
    } else {
        jar.uninit(false);
        jars.removeElement(jar);
        if (!isMainThread())
            initKeyBindings();
    }
    EditBus.send(new PluginUpdate(jar, PluginUpdate.UNLOADED, exit));
    if (!isMainThread() && !exit)
        EditBus.send(new DynamicMenuChanged("plugins"));
}