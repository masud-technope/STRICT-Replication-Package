//}}}
//{{{ paintComponent() method
public void paintComponent(Graphics _gfx) {
    Graphics2D gfx = (Graphics2D) _gfx;
    gfx.setRenderingHints(textArea.getPainter().renderingHints);
    // fill the background
    Rectangle clip = gfx.getClipBounds();
    gfx.setColor(getBackground());
    int bgColorWidth = isSelectionAreaEnabled() ? FOLD_MARKER_SIZE : clip.width;
    gfx.fillRect(clip.x, clip.y, bgColorWidth, clip.height);
    if (isSelectionAreaEnabled()) {
        if (selectionAreaBgColor == null)
            selectionAreaBgColor = getBackground();
        gfx.setColor(selectionAreaBgColor);
        gfx.fillRect(clip.x + FOLD_MARKER_SIZE, clip.y, clip.width - FOLD_MARKER_SIZE, clip.height);
    }
    // if buffer is loading, don't paint anything
    if (textArea.getBuffer().isLoading())
        return;
    int lineHeight = textArea.getPainter().getLineHeight();
    if (lineHeight == 0)
        return;
    int firstLine = clip.y / lineHeight;
    int lastLine = (clip.y + clip.height - 1) / lineHeight;
    if (lastLine - firstLine > textArea.getVisibleLines()) {
        Log.log(Log.ERROR, this, "BUG: firstLine=" + firstLine);
        Log.log(Log.ERROR, this, "     lastLine=" + lastLine);
        Log.log(Log.ERROR, this, "     visibleLines=" + textArea.getVisibleLines());
        Log.log(Log.ERROR, this, "     height=" + getHeight());
        Log.log(Log.ERROR, this, "     painter.height=" + lineHeight);
        Log.log(Log.ERROR, this, "     clip.y=" + clip.y);
        Log.log(Log.ERROR, this, "     clip.height=" + clip.height);
        Log.log(Log.ERROR, this, "     lineHeight=" + lineHeight);
    }
    int y = clip.y - clip.y % lineHeight + textArea.getPainter().getLineExtraSpacing();
    extensionMgr.paintScreenLineRange(textArea, gfx, firstLine, lastLine, y, lineHeight);
    for (int line = firstLine; line <= lastLine; line++, y += lineHeight) {
        paintLine(gfx, line, y);
    }
}