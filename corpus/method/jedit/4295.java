//}}}
//{{{ Colors and styles
//{{{ parseColor() method
/**
	 * Converts a color name to a color object. The name must either be
	 * a known string, such as `red', `green', etc (complete list is in
	 * the <code>java.awt.Color</code> class) or a hex color value
	 * prefixed with `#', for example `#ff0088'.
	 * @param name The color name
	 * @deprecated use {@link SyntaxUtilities#parseColor(String, Color)}
	 */
public static Color parseColor(String name) {
    return SyntaxUtilities.parseColor(name, Color.black);
}