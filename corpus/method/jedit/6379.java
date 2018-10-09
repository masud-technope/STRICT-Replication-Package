//}}}
//{{{ getServiceNames() method
/**
	 * Returns the names of all registered services with the given
	 * class. For example, calling this with a parameter of
	 * "org.gjt.sp.jedit.io.VFS" returns all known virtual file
	 * systems.
	 *
	 * @param clazz The class name
	 * @since jEdit 4.2pre1
	 */
public static String[] getServiceNames(String clazz) {
    List<String> returnValue = new ArrayList<String>();
    Set<Descriptor> keySet = serviceMap.keySet();
    for (Descriptor d : keySet) if (d.clazz.equals(clazz))
        returnValue.add(d.name);
    return returnValue.toArray(new String[returnValue.size()]);
}