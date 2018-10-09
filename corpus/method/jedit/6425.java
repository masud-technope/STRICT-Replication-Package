//}}}
//{{{ drawGlyphs() method
/**
	 * Draws the internal list of glyph vectors into the given
	 * graphics object.
	 *
	 * @param	gfx	Where to draw the glyphs.
	 * @param	x	Starting horizontal position.
	 * @param	y	Vertical position.
	 */
private void drawGlyphs(Graphics2D gfx, float x, float y) {
    for (GlyphVector gv : glyphs) {
        gfx.drawGlyphVector(gv, x, y);
        x += (float) gv.getLogicalBounds().getWidth();
    }
}