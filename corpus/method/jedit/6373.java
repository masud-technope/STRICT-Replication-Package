//}}}
//{{{ registerService() method
/**
	 * Registers a service. Plugins should provide a
	 * <code>services.xml</code> file instead of calling this directly.
	 *
	 * @param clazz The service class
	 * @param name The service name
	 * @param code BeanShell code to create an instance of this
	 * @param plugin The plugin JAR, or null if this is a built-in service
	 *
	 * @since jEdit 4.2pre1
	 */
public static void registerService(String clazz, String name, String code, PluginJAR plugin) {
    Descriptor d = new Descriptor(clazz, name, code, plugin);
    serviceMap.put(d, d);
}