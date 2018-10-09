//}}}
//{{{ getScreenLineOfOffset() method
/**
	 * Returns the screen (wrapped) line containing the specified offset.
	 * Returns -1 if the line is not currently visible on the screen.
	 * @param offset The offset
	 * @since jEdit 4.0pre4
	 */
public int getScreenLineOfOffset(int offset) {
    int line = buffer.getLineOfOffset(offset);
    offset -= buffer.getLineStartOffset(line);
    return chunkCache.getScreenLineOfOffset(line, offset);
}