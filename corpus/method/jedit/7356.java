//}}}
//{{{ updateRenderingHints() method
private void updateRenderingHints() {
    Map<RenderingHints.Key, Object> hints = new HashMap<RenderingHints.Key, Object>();
    hints.put(RenderingHints.KEY_FRACTIONALMETRICS, fracFontMetrics ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF);
    hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, antiAlias.renderHint());
    if (antiAlias.val() == 0) {
        hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        fontRenderContext = new FontRenderContext(null, antiAlias.val() > 0, fracFontMetrics);
    } else /* Subpixel antialiasing mode */
    if (antiAlias.val() > 1) {
        Object fontRenderHint = fracFontMetrics ? RenderingHints.VALUE_FRACTIONALMETRICS_ON : RenderingHints.VALUE_FRACTIONALMETRICS_OFF;
        fontRenderContext = new FontRenderContext(null, antiAlias.renderHint(), fontRenderHint);
    } else /** Standard Antialias Version */
    {
        hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        hints.put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        fontRenderContext = new FontRenderContext(null, antiAlias.val() > 0, fracFontMetrics);
    }
    renderingHints = new RenderingHints(hints);
}