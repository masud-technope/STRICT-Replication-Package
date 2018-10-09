//}}}
//{{{ invalidateLine() method
/**
	 * Marks a line as needing a repaint.
	 * @param line The physical line to invalidate
	 */
public void invalidateLine(int line) {
    if (!isShowing() || buffer.isLoading() || line < getFirstPhysicalLine() || line > physLastLine || !displayManager.isLineVisible(line))
        return;
    int startLine = -1;
    int endLine = -1;
    for (int i = 0; i < visibleLines; i++) {
        ChunkCache.LineInfo info = chunkCache.getLineInfo(i);
        if ((info.physicalLine >= line || info.physicalLine == -1) && startLine == -1) {
            startLine = i;
        }
        if ((info.physicalLine >= line && info.lastSubregion) || info.physicalLine == -1) {
            endLine = i;
            break;
        }
    }
    if (chunkCache.needFullRepaint() || endLine == -1)
        endLine = visibleLines;
    invalidateScreenLineRange(startLine, endLine);
}