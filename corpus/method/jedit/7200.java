//}}}
//{{{ getVisibleLineText() methods
/**
	 * Returns the visible part of the given line
	 * @param screenLine the screenLine
	 * @return the visible text
	 * @since 4.5pre1
	 */
public String getVisibleLineText(int screenLine) {
    int offset = -getHorizontalOffset();
    ChunkCache.LineInfo lineInfo = chunkCache.getLineInfo(screenLine);
    if (lineInfo.physicalLine == -1)
        return "";
    int lineStartOffset = getLineStartOffset(lineInfo.physicalLine);
    Point point = offsetToXY(lineStartOffset + lineInfo.offset);
    int begin = xyToOffset(offset + point.x, point.y);
    int end = xyToOffset(getPainter().getWidth(), point.y);
    return buffer.getText(begin, end - begin);
}