//}}}
//{{{ paint() method
/**
	 * Repaints the text.
	 * @param _gfx The graphics context
	 */
@Override
public void paint(Graphics _gfx) {
    assert _gfx instanceof Graphics2D;
    Graphics2D gfx = (Graphics2D) _gfx;
    gfx.setRenderingHints(renderingHints);
    fontRenderContext = gfx.getFontRenderContext();
    Rectangle clipRect = gfx.getClipBounds();
    int lineHeight = getLineHeight();
    int charHeight = getFontHeight();
    if (lineHeight == 0 || textArea.getBuffer().isLoading()) {
        gfx.setColor(getBackground());
        gfx.fillRect(clipRect.x, clipRect.y, clipRect.width, clipRect.height);
    } else {
        long prepareTime = System.nanoTime();
        // Because the clipRect's height is usually an even multiple
        // of the font height, we subtract 1 from it, otherwise one
        // too many lines will always be painted.
        int firstLine = clipRect.y / lineHeight;
        int lastLine = (clipRect.y + clipRect.height - 1) / lineHeight;
        gfx.setColor(getBackground());
        gfx.setFont(getFont());
        prepareTime = System.nanoTime() - prepareTime;
        long linesTime = System.nanoTime();
        int numLines = lastLine - firstLine + 1;
        int y = firstLine * lineHeight;
        gfx.fillRect(0, y, getWidth(), numLines * lineHeight);
        extensionMgr.paintScreenLineRange(textArea, gfx, firstLine, lastLine, y, lineHeight);
        linesTime = System.nanoTime() - linesTime;
        if (Debug.PAINT_TIMER && numLines >= 1)
            Log.log(Log.DEBUG, this, "repainting " + numLines + " lines took " + prepareTime + "/" + linesTime + " ns");
    }
    textArea.updateMaxHorizontalScrollWidth();
}