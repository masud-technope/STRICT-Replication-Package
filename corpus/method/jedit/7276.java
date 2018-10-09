//}}}
//{{{ recalculateVisibleLines() method
void recalculateVisibleLines() {
    if (painter == null)
        return;
    int height = painter.getHeight();
    int lineHeight = painter.getLineHeight();
    if (lineHeight == 0)
        visibleLines = 0;
    else if (height <= 0) {
        visibleLines = 0;
        lastLinePartial = false;
    } else {
        visibleLines = height / lineHeight;
        lastLinePartial = height % lineHeight != 0;
        if (lastLinePartial)
            visibleLines++;
    }
    chunkCache.recalculateVisibleLines();
    // this does the "trick" to eliminate blank space at the end
    if (displayManager != null && buffer != null && !buffer.isLoading())
        setFirstLine(getFirstLine());
    updateScrollBar();
}