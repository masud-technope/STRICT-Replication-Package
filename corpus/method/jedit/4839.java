//}}}
//{{{ setBooleanProperty() method
/**
	 * Sets a boolean property.
	 * @param name The property
	 * @param value The value
	 */
public static void setBooleanProperty(String name, boolean value) {
    setProperty(name, value ? "true" : "false");
}