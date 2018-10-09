//}}}
//{{{ xToScreenLineOffset() method
/**
	 * Converts a point in a given screen line to an offset.
	 *
	 * @param x The x co-ordinate of the point
	 * @param screenLine The screen line
	 * @param round Round up to next character if past the middle of a character?
	 * @since jEdit 3.2pre6
	 */
public int xToScreenLineOffset(int screenLine, int x, boolean round) {
    ChunkCache.LineInfo lineInfo = chunkCache.getLineInfo(screenLine);
    if (lineInfo.physicalLine == -1) {
        return getLineEndOffset(displayManager.getLastVisibleLine()) - 1;
    } else {
        float xInLine = x - horizontalOffset;
        int offsetInLine = Chunk.xToOffset(lineInfo.chunks, xInLine, false);
        int lineStartOffset = getLineStartOffset(lineInfo.physicalLine);
        if (offsetInLine == -1 || offsetInLine == lineInfo.offset + lineInfo.length)
            return lineStartOffset + lineInfo.offset + lineInfo.length - 1;
        int offset = lineStartOffset + offsetInLine;
        final LineCharacterBreaker charBreaker = new LineCharacterBreaker(this, offset);
        int lower = charBreaker.offsetIsBoundary(offset) ? offset : charBreaker.previousOf(offset);
        if (round) {
            float lowerX = Chunk.offsetToX(lineInfo.chunks, lower - lineStartOffset);
            int upper = charBreaker.nextOf(lower);
            float upperX = Chunk.offsetToX(lineInfo.chunks, upper - lineStartOffset);
            return (xInLine < ((lowerX + upperX) / 2)) ? lower : upper;
        } else {
            return lower;
        }
    }
}