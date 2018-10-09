//}}}
//{{{ unloadServices() method
/**
	 * Removes all services belonging to the specified plugin.
	 * @param plugin The plugin
	 * @since jEdit 4.2pre1
	 */
public static void unloadServices(PluginJAR plugin) {
    Iterator<Descriptor> descriptors = serviceMap.keySet().iterator();
    while (descriptors.hasNext()) {
        Descriptor d = descriptors.next();
        if (d.plugin == plugin)
            descriptors.remove();
    }
}