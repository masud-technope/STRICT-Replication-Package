//}}}
//{{{ getPlugin() method
/**
	 * Returns the plugin with the specified class name.
	 * Only works for plugins that were loaded.
	 */
public static EditPlugin getPlugin(String name) {
    return getPlugin(name, false);
}