//}}}
//{{{ setColorProperty() method
/**
	 * Sets the value of a color property.
	 * @param name The property name
	 * @param value The value
	 * @since jEdit 4.0pre1
	 */
public static void setColorProperty(String name, Color value) {
    setProperty(name, SyntaxUtilities.getColorHexString(value));
}