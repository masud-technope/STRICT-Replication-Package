// }}}
//{{{ layoutGlyphs() method
/**
	 * Layout the glyphs to render the given text, applying font
	 * substitution if configured.
	 *
	 * Font substitution works in the following manner:
	 *	- All characters that can be rendered with the main
	 *	  font will be.
	 *	- For characters that can't be handled by the main
	 *	  font, iterate over the list of available fonts to
	 *	  find an appropriate one. The first match is chosen.
	 *
	 * The user can define his list of preferred fonts, which will
	 * be tried before the system fonts.
	 */
private static GlyphVector[] layoutGlyphs(Font mainFont, FontRenderContext frc, char[] text, int start, int end) {
    int substStart = !fontSubstEnabled ? -1 : mainFont.canDisplayUpTo(text, start, end);
    if (substStart == -1) {
        GlyphVector gv = layoutGlyphVector(mainFont, frc, text, start, end);
        return new GlyphVector[] { gv };
    } else {
        FontSubstitution subst = new FontSubstitution(mainFont, frc, text, start);
        subst.addNonSubstRange(substStart - start);
        doFontSubstitution(subst, mainFont, text, substStart, end);
        subst.finish();
        return subst.getGlyphs();
    }
}