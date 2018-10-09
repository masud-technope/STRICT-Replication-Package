//}}}
//{{{ invalidateLineRange() method
/**
	 * Marks a range of physical lines as needing a repaint.
	 * @param start The first line to invalidate
	 * @param end The last line to invalidate
	 */
public void invalidateLineRange(int start, int end) {
    if (!isShowing() || buffer.isLoading())
        return;
    if (end < start) {
        int tmp = end;
        end = start;
        start = tmp;
    }
    if (end < getFirstPhysicalLine() || start > getLastPhysicalLine())
        return;
    int startScreenLine = -1;
    int endScreenLine = -1;
    for (int i = 0; i < visibleLines; i++) {
        ChunkCache.LineInfo info = chunkCache.getLineInfo(i);
        if ((info.physicalLine >= start || info.physicalLine == -1) && startScreenLine == -1) {
            startScreenLine = i;
        }
        if ((info.physicalLine >= end && info.lastSubregion) || info.physicalLine == -1) {
            endScreenLine = i;
            break;
        }
    }
    if (startScreenLine == -1)
        startScreenLine = 0;
    if (chunkCache.needFullRepaint() || endScreenLine == -1)
        endScreenLine = visibleLines;
    invalidateScreenLineRange(startScreenLine, endScreenLine);
}