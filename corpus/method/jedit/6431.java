//}}}
//{{{ getGlyphCache() method
private static GlyphCache getGlyphCache() {
    if (glyphCache != null) {
        GlyphCache cache = glyphCache.get();
        if (cache != null) {
            return cache;
        }
    }
    GlyphCache newOne = new GlyphCache(glyphCacheCapacity);
    glyphCache = new SoftReference<GlyphCache>(newOne);
    return newOne;
}