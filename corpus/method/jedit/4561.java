//}}}
//{{{ getAvailableNames() method
/**
	 * Returns the set of all available encoding names.
	 */
public static Set<String> getAvailableNames() {
    Set<String> set = new HashSet<String>();
    set.addAll(Charset.availableCharsets().keySet());
    set.addAll(Arrays.asList(ServiceManager.getServiceNames(serviceClass)));
    return set;
}