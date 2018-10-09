//}}}
//{{{ getServiceTypes() method
/**
	 * Returns all known service class types.
	 *
	 * @since jEdit 4.2pre1
	 */
public static String[] getServiceTypes() {
    Set<String> returnValue = new HashSet<String>();
    Set<Descriptor> keySet = serviceMap.keySet();
    for (Descriptor d : keySet) returnValue.add(d.clazz);
    return returnValue.toArray(new String[returnValue.size()]);
}