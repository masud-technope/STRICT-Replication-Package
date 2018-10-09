/**
	 * Converts a line,offset pair into an x,y (pixel) point relative to the
	 * upper left corner (0,0) of the text area.
	 *
	 * @param line The physical line number (from top of document)
	 * @param offset The offset in characters, from the start of the line
	 * @param retVal The point to store the return value in
	 * @return <code>retVal</code> for convenience, or <code>null</code>
	 * if the specified offset is not visible
	 * @since jEdit 4.0pre4
	 */
public Point offsetToXY(int line, int offset, Point retVal) {
    if (!displayManager.isLineVisible(line))
        return null;
    int screenLine = chunkCache.getScreenLineOfOffset(line, offset);
    if (screenLine == -1)
        return null;
    retVal.y = screenLine * painter.getLineHeight();
    ChunkCache.LineInfo info = chunkCache.getLineInfo(screenLine);
    retVal.x = (int) (horizontalOffset + Chunk.offsetToX(info.chunks, offset));
    return retVal;
}