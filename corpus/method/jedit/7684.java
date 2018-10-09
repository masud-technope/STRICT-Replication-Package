/**
	 * Loads the syntax styles from the properties, giving them the specified
	 * base font family and size.
	 * @param family The font family
	 * @param size The font size
	 * @param color If false, the styles will be monochrome
	 * @since jEdit 4.3pre13
	 */
public static SyntaxStyle[] loadStyles(String family, int size, boolean color) {
    SyntaxStyle[] styles = new SyntaxStyle[Token.ID_COUNT];
    // start at 1 not 0 to skip Token.NULL
    for (int i = 1; i < styles.length; i++) {
        try {
            String styleName = "view.style." + Token.tokenToString((byte) i).toLowerCase(Locale.ENGLISH);
            styles[i] = parseStyle(propertyManager.getProperty(styleName), family, size, color);
        } catch (Exception e) {
            Log.log(Log.ERROR, StandardUtilities.class, e);
        }
    }
    return styles;
}