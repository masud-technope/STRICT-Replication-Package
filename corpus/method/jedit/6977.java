/**
	 * Returns the value of a boolean property.
	 * @param name The property
	 * @param def The default value
	 */
private boolean getBooleanProperty(String name, boolean def) {
    String value = getProperty(name);
    if (value == null)
        return def;
    else if ("true".equals(value) || "yes".equals(value) || "on".equals(value))
        return true;
    else if ("false".equals(value) || "no".equals(value) || "off".equals(value))
        return false;
    else
        return def;
}