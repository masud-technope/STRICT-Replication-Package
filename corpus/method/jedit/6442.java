//}}}
//{{{ offsetToX() method
final float offsetToX(int offset) {
    if (glyphs == null)
        return 0.0f;
    float x = 0.0f;
    for (GlyphVector gv : glyphs) {
        if (offset < gv.getNumGlyphs()) {
            x += (float) gv.getGlyphPosition(offset).getX();
            return x;
        }
        x += (float) gv.getLogicalBounds().getWidth();
        offset -= gv.getNumGlyphs();
    }
    /* Shouldn't reach this. */
    assert false : "Shouldn't reach this.";
    return -1;
}