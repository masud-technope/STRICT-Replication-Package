//}}}
//{{{ parseStyle() method
/**
	 * Converts a style string to a style object.
	 * @param str The style string
	 * @param family Style strings only specify font style, not font family
	 * @param size Style strings only specify font style, not font family
	 * @exception IllegalArgumentException if the style is invalid
	 * @since jEdit 3.2pre6
	 * @deprecated use {@link SyntaxUtilities#parseStyle(String, String, int, boolean)}
	 */
public static SyntaxStyle parseStyle(String str, String family, int size) throws IllegalArgumentException {
    return SyntaxUtilities.parseStyle(str, family, size, true);
}