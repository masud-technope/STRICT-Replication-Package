//}}}
//{{{ getService() methods
/**
	 * Returns an instance of the given service. The first time this is
	 * called for a given service, the BeanShell code is evaluated. The
	 * result is cached for future invocations, so in effect services are
	 * singletons.
	 *
	 * @param clazz The service class
	 * @param name The service name
	 * @since jEdit 4.2pre1
	 */
public static Object getService(String clazz, String name) {
    Descriptor key = new Descriptor(clazz, name);
    Descriptor value = serviceMap.get(key);
    if (value == null) {
        // unknown service - <clazz,name> not in table
        return null;
    } else {
        if (value.code == null) {
            loadServices(value.plugin, value.plugin.getServicesURI(), null);
            value = serviceMap.get(key);
        }
        return value.getInstance();
    }
}