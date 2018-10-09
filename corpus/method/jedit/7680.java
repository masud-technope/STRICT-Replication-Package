//}}}
//{{{ parseStyle() method
/**
	 * Converts a style string to a style object.
	 * @param str The style string
	 * @param family Style strings only specify font style, not font family
	 * @param size Style strings only specify font style, not font family
	 * @param color If false, the styles will be monochrome
	 * @param defaultFgColor Default foreground color (if not specified in style string)
	 * @exception IllegalArgumentException if the style is invalid
	 * @since jEdit 4.3pre17
	 */
public static SyntaxStyle parseStyle(String str, String family, int size, boolean color, Color defaultFgColor) throws IllegalArgumentException {
    Color fgColor = defaultFgColor;
    Color bgColor = null;
    boolean italic = false;
    boolean bold = false;
    StringTokenizer st = new StringTokenizer(str);
    while (st.hasMoreTokens()) {
        String s = st.nextToken();
        if (s.startsWith("color:")) {
            if (color)
                fgColor = parseColor(s.substring(6), Color.black);
        } else if (s.startsWith("bgColor:")) {
            if (color)
                bgColor = parseColor(s.substring(8), null);
        } else if (s.startsWith("style:")) {
            for (int i = 6; i < s.length(); i++) {
                if (s.charAt(i) == 'i')
                    italic = true;
                else if (s.charAt(i) == 'b')
                    bold = true;
                else
                    throw new IllegalArgumentException("Invalid style: " + s);
            }
        } else
            throw new IllegalArgumentException("Invalid directive: " + s);
    }
    return new SyntaxStyle(fgColor, bgColor, new Font(family, (italic ? Font.ITALIC : 0) | (bold ? Font.BOLD : 0), size));
}