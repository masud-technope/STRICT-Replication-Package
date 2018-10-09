//}}}
//{{{ getIntegerProperty() method
/**
	 * Returns the value of an integer property.
	 * @param name The property
	 * @param def The default value
	 * @since jEdit 4.0pre1
	 */
private int getIntegerProperty(String name, int def) {
    String value = getProperty(name);
    if (value == null)
        return def;
    else {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException nf) {
            return def;
        }
    }
}