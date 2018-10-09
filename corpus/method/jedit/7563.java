//{{{ public section
//{{{ parseHighlightStyle()
/**
	 * Parses a string specifying a syntax highlight style.
	 *
	 * The syntax highlight string should be in the same format used to
	 * store syntax highlight styles in the properties.
	 *
	 * @param style The syntax highlight style string.
	 * @param f The font to which the syntax style will apply.
	 * @return The SyntaxStyle object represented by the style string.
	 */
public static SyntaxStyle parseHighlightStyle(String style, Font f) {
    SyntaxStyle s;
    try {
        s = SyntaxUtilities.parseStyle(style, f.getFamily(), f.getSize(), true, null);
    } catch (Exception e) {
        style = "color:#000000";
        s = SyntaxUtilities.parseStyle(style, f.getFamily(), f.getSize(), true);
    }
    return s;
}