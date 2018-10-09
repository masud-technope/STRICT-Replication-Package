//}}}
//{{{ getLineEndOffset() method
/**
	 * Returns the end offset of the specified line.
	 * This method is thread-safe.
	 * @param line The line
	 * @return The end offset of the specified line, that is the offset
	 * after the end-of-line character. Note that
	 * <code>buffer.getLineOfOffset(buffer.getLineEndOffset(x))</code>
	 * does not return <code>x</code> but <code>x+1</code>.
	 * @since jEdit 4.0pre1
	 */
public int getLineEndOffset(int line) {
    try {
        readLock();
        if (line < 0 || line >= lineMgr.getLineCount())
            throw new ArrayIndexOutOfBoundsException(line);
        return lineMgr.getLineEndOffset(line);
    } finally {
        readUnlock();
    }
}