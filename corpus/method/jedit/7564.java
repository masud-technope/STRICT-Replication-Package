//}}}
//{{{ style2html()
/**
	 * Parses a string specifying a syntax highlight style, and creates an
	 * HTML representation for it.
	 *
	 * The syntax highlight string should be in the same format used to
	 * store syntax highlight styles in the properties.
	 *
	 * @param prop The syntax highlight style string.
	 * @param f The font to which the syntax style will apply.
	 * @return The HTML representation of the given syntax style. 
	 */
public static String style2html(String prop, Font f) {
    StringBuilder tag = new StringBuilder();
    SyntaxStyle style = parseHighlightStyle(prop, f);
    Color c = style.getForegroundColor();
    if (c != null)
        tag.append("color:").append(color2html(c));
    c = style.getBackgroundColor();
    if (c != null)
        tag.append("background:").append(color2html(c));
    f = style.getFont();
    if (f.isBold())
        tag.append("font-weight:bold;");
    if (f.isItalic())
        tag.append("font-style: italic;");
    return tag.toString();
}