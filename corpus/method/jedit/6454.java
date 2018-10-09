//}}}
//{{{ usedFontSubstitution() method
/**
	 * Returns true if font substitution was used in the layout of this chunk.
	 * If substitution was not used, the chunk may be assumed to be composed
	 * of one glyph using a single font.
	 */
public boolean usedFontSubstitution() {
    return (fontSubstEnabled && glyphs != null && (glyphs.length > 1 || (glyphs.length == 1 && glyphs[0].getFont() != style.getFont())));
}