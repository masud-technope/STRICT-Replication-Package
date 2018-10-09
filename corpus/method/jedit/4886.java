//}}}
//{{{ getBooleanProperty() method
/**
	 * Returns the value of a boolean property.
	 * @param name The property
	 * @param def The default value
	 */
public static boolean getBooleanProperty(String name, boolean def) {
    String value = getProperty(name);
    return StandardUtilities.getBoolean(value, def);
}