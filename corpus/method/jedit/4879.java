//}}}
//{{{ getColorProperty() method
/**
	 * Returns the value of a color property.
	 * @param name The property name
	 * @param def The default value
	 * @since jEdit 4.0pre1
	 */
public static Color getColorProperty(String name, Color def) {
    String value = getProperty(name);
    if (value == null)
        return def;
    else
        return SyntaxUtilities.parseColor(value, def);
}