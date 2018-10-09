/**
	 * Returns the specified line from the starting point passed in relativeStartOffset  in a <code>Segment</code>.<p>
	 *
	 * Using a <code>Segment</code> is generally more
	 * efficient than using a <code>String</code> because it
	 * results in less memory allocation and array copying.<p>
	 *
	 * This method is thread-safe.
	 *
	 * @param line The line
	 * @param segment the segment
	 * @param relativeStartOffset the relative start offset
	 * @since jEdit 4.0pre1
	 */
public void getLineText(int line, int relativeStartOffset, Segment segment) {
    if (line < 0 || line >= lineMgr.getLineCount())
        throw new ArrayIndexOutOfBoundsException(line);
    try {
        readLock();
        int start = (line == 0 ? 0 : lineMgr.getLineEndOffset(line - 1));
        int end = lineMgr.getLineEndOffset(line);
        if ((start + relativeStartOffset) > end) {
            throw new IllegalArgumentException("This index is outside the line length (start+relativeOffset):" + start + " + " + relativeStartOffset + " > " + "endffset:" + end);
        } else {
            getText(start + relativeStartOffset, end - start - relativeStartOffset - 1, segment);
        }
    } finally {
        readUnlock();
    }
}