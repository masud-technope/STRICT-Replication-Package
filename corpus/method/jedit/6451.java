//}}}
//{{{ deriveSubstFont() method
/**
	 * Derives a font to match the main font for purposes of
	 * font substitution.
	 * Preserves any transformations from main font.
	 * For system-fallback fonts, derives size and style from main font.
	 *
	 * @param mainFont Font to derive from
	 * @param candidateFont Font to transform
	 */
public static Font deriveSubstFont(Font mainFont, Font candidateFont) {
    // adopt subst font family and size, but preserve any transformations
    // i.e. if font is squashed/sheared, subst font glyphs should be squashed
    Font substFont = candidateFont.deriveFont(mainFont.getTransform());
    // scale up system fonts (point size 1) to size of main font
    if (substFont.getSize() == 1)
        substFont = substFont.deriveFont(mainFont.getStyle(), mainFont.getSize());
    return substFont;
}