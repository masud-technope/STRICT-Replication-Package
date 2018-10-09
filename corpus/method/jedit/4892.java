//}}}
//{{{ getProperty() method
/**
	 * Fetches a property, returning null if it's not defined.
	 * @param name The property
	 */
public static String getProperty(String name) {
    return propMgr.getProperty(name);
}