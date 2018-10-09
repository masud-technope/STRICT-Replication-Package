//}}}
//{{{ setIntegerProperty() method
/**
	 * Sets the value of an integer property.
	 * @param name The property
	 * @param value The value
	 * @since jEdit 4.0pre1
	 */
public static void setIntegerProperty(String name, int value) {
    setProperty(name, String.valueOf(value));
}