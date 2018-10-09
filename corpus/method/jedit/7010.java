//}}}
//{{{ getScreenLineStartOffset() method
/**
	 * Returns the start offset of the specified screen (wrapped) line.
	 * @param line The line
	 * @since jEdit 4.0pre4
	 */
public int getScreenLineStartOffset(int line) {
    ChunkCache.LineInfo lineInfo = chunkCache.getLineInfo(line);
    if (lineInfo.physicalLine == -1)
        return -1;
    return buffer.getLineStartOffset(lineInfo.physicalLine) + lineInfo.offset;
}