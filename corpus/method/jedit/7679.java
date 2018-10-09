//}}}
//{{{ parseStyle() method
/**
	 * Converts a style string to a style object.
	 * @param str The style string
	 * @param family Style strings only specify font style, not font family
	 * @param size Style strings only specify font style, not font family
	 * @param color If false, the styles will be monochrome
	 * @exception IllegalArgumentException if the style is invalid
	 * @since jEdit 4.3pre13
	 */
public static SyntaxStyle parseStyle(String str, String family, int size, boolean color) throws IllegalArgumentException {
    return parseStyle(str, family, size, color, Color.black);
}