//}}}
//{{{ getColorProperty() method
/**
	 * Returns the value of a color property.
	 * @param name The property name
	 * @since jEdit 4.0pre1
	 */
public static Color getColorProperty(String name) {
    return getColorProperty(name, Color.black);
}