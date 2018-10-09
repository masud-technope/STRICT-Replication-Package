//}}}
//{{{ getProperty() method
/**
	 * Fetches a property, returning the default value if it's not
	 * defined.
	 * @param name The property
	 * @param def The default value
	 */
public static String getProperty(String name, String def) {
    String value = propMgr.getProperty(name);
    if (value == null)
        return def;
    else
        return value;
}