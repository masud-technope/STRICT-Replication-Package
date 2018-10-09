//}}}
//{{{ xToOffset() method
final int xToOffset(float x, boolean round) {
    if (glyphs == null) {
        if (round && width - x < x)
            return offset + length;
        else
            return offset;
    }
    int off = offset;
    float myx = 0.0f;
    for (GlyphVector gv : glyphs) {
        float gwidth = (float) gv.getLogicalBounds().getWidth();
        if (myx + gwidth >= x) {
            float[] pos = gv.getGlyphPositions(0, gv.getNumGlyphs(), null);
            for (int i = 0; i < gv.getNumGlyphs(); i++) {
                float glyphX = myx + pos[i << 1];
                float nextX = (i == gv.getNumGlyphs() - 1) ? width : myx + pos[(i << 1) + 2];
                if (nextX > x) {
                    if (!round || nextX - x > x - glyphX)
                        return off + i;
                    else
                        return off + i + 1;
                }
            }
        }
        myx += gwidth;
        off += gv.getNumGlyphs();
    }
    /* Shouldn't reach this. */
    assert false : "Shouldn't reach this.";
    return -1;
}