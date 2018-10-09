//{{{ RotatedTextIcon constructor
public  RotatedTextIcon(int rotate, Font font, String text) {
    this.rotate = rotate;
    this.font = font;
    FontRenderContext fontRenderContext = new FontRenderContext(null, true, false);
    glyphs = font.createGlyphVector(fontRenderContext, text);
    width = (int) glyphs.getLogicalBounds().getWidth() + 4;
    //height = (int)glyphs.getLogicalBounds().getHeight();
    LineMetrics lineMetrics = font.getLineMetrics(text, fontRenderContext);
    ascent = lineMetrics.getAscent();
    height = (int) lineMetrics.getHeight();
    renderHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    renderHints.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
    renderHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
//}}}
}