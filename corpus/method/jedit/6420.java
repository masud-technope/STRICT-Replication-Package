//}}}
//{{{ getFontSubstList() method
/**
	 * Obtain a list of preferred fallback fonts as specified by the user
	 * (see Text Area in Global Options), as well as a list of all fonts
	 * specified in the system.
	 * Note that preferred fonts are returned with sizes as specified by the
	 * user, but system fonts all have a point size of 1. These should be
	 * scaled up once the main font is known (see layoutGlyphs()).
	 */
private static Font[] getFontSubstList() {
    if (fontSubstList == null) {
        if (fontSubstSystemFontsEnabled) {
            Font[] systemFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
            fontSubstList = new Font[preferredFonts.length + systemFonts.length];
            System.arraycopy(preferredFonts, 0, fontSubstList, 0, preferredFonts.length);
            System.arraycopy(systemFonts, 0, fontSubstList, preferredFonts.length, systemFonts.length);
        } else {
            fontSubstList = new Font[preferredFonts.length];
            System.arraycopy(preferredFonts, 0, fontSubstList, 0, preferredFonts.length);
        }
    }
    return fontSubstList;
}