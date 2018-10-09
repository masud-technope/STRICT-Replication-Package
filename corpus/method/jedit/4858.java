//}}}
//{{{ getPlugin(String, boolean) method
/**
	 * Returns the plugin with the specified class name.
	 * If * <code>loadIfNecessary</code> is true, the plugin will be searched for,
	 * loaded, and activated in case it has not yet been loaded.
	 *
	 * @param name the classname of the main Plugin class.
	 * @param loadIfNecessary - loads plugin + dependencies if it is not loaded yet.
	 * @since jEdit 4.2pre4
	 */
public static EditPlugin getPlugin(String name, boolean loadIfNecessary) {
    if (name == null) {
        return null;
    }
    EditPlugin[] plugins = getPlugins();
    EditPlugin plugin = null;
    for (EditPlugin ep : plugins) {
        if (ep.getClassName().equals(name)) {
            plugin = ep;
            break;
        }
    }
    if (!loadIfNecessary) {
        return plugin;
    }
    if (plugin instanceof EditPlugin.Deferred) {
        plugin.getPluginJAR().activatePlugin();
        plugin = plugin.getPluginJAR().getPlugin();
    }
    String jarPath = PluginJAR.findPlugin(name);
    PluginJAR pjar = PluginJAR.load(jarPath, true);
    return pjar.getPlugin();
}