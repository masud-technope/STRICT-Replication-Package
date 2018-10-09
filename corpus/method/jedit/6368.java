//}}}
//{{{ Package-private members
//{{{ registerService() method
/**
	 * Registers a service.
	 *
	 * @param d the service descriptor
	 * @since jEdit 4.2pre1
	 */
static void registerService(Descriptor d) {
    serviceMap.put(d, d);
}