/**
	 * Returns the visible part of the given line
	 * @param screenLine the screenLine
	 * @param segment the segment into which the data will be stored.
	 * @since 4.5pre1
	 */
public void getVisibleLineText(int screenLine, Segment segment) {
    int offset = -getHorizontalOffset();
    ChunkCache.LineInfo lineInfo = chunkCache.getLineInfo(screenLine);
    if (lineInfo.physicalLine == -1)
        return;
    int lineStartOffset = getLineStartOffset(lineInfo.physicalLine);
    Point point = offsetToXY(lineStartOffset + lineInfo.offset);
    int begin = xyToOffset(offset + point.x, point.y);
    int end = xyToOffset(getPainter().getWidth(), point.y);
    buffer.getText(begin, end - begin, segment);
}