/**
     * Returns an instance of the given service. The first time this is
	 * called for a given service, the BeanShell code is evaluated. The
	 * result is cached for future invocations, so in effect services are
	 * singletons.
     *
     * @param clazz The service class
	 * @param name The service name
     * @return the service instance
     * @since jEdit 4.4pre1
     */
@SuppressWarnings({ "unchecked" })
public static <E> E getService(Class<E> clazz, String name) {
    return (E) getService(clazz.getName(), name);
}