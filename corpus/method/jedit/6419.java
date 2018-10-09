//}}}
//{{{ init() method
void init(Segment lineText, TabExpander expander, float x, FontRenderContext fontRenderContext, int physicalLineOffset) {
    if (!isAccessible()) {
    // do nothing
    } else if (isTab(lineText)) {
        float newX = expander.nextTabStop(x, physicalLineOffset + offset);
        width = newX - x;
    } else {
        str = new String(lineText.array, lineText.offset + offset, length);
        GlyphKey cacheKey = new GlyphKey(str, style.getFont(), fontRenderContext);
        GlyphCache cache = getGlyphCache();
        GlyphVector[] cachedGlyphs = cache.get(cacheKey);
        if (cachedGlyphs != null) {
            glyphs = cachedGlyphs;
        } else {
            int textStart = lineText.offset + offset;
            int textEnd = textStart + length;
            glyphs = layoutGlyphs(style.getFont(), fontRenderContext, lineText.array, textStart, textEnd);
            cache.put(cacheKey, glyphs);
        }
        float w = 0.0f;
        for (GlyphVector gv : glyphs) {
            w += (float) gv.getLogicalBounds().getWidth();
        }
        width = w;
    }
    assert isInitialized();
}