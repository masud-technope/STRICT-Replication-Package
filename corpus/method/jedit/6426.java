//}}}
//{{{ layoutGlyphVector() method
/**
	 * A wrapper of Font.layoutGlyphVector() to simplify the calls.
	 */
private static GlyphVector layoutGlyphVector(Font font, FontRenderContext frc, char[] text, int start, int end) {
    // FIXME: Need BiDi support.
    int flags = Font.LAYOUT_LEFT_TO_RIGHT | Font.LAYOUT_NO_START_CONTEXT | Font.LAYOUT_NO_LIMIT_CONTEXT;
    GlyphVector result = font.layoutGlyphVector(frc, text, start, end, flags);
    // This is necessary to work around a memory leak in Sun Java 6 where
    // the sun.font.GlyphLayout is cached and reused while holding an
    // instance to the char array.
    font.layoutGlyphVector(frc, EMPTY_TEXT, 0, 0, flags);
    return result;
}