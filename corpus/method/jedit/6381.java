//}}}
//{{{ unregisterService() method
/**
	 * Unregisters a service.
	 *
	 * @param clazz The service class
	 * @param name The service name
	 *
	 * @since jEdit 4.2pre1
	 */
public static void unregisterService(String clazz, String name) {
    Descriptor d = new Descriptor(clazz, name);
    serviceMap.remove(d);
}