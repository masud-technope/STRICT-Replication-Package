/**
	 * Called when text is removed from the buffer.
	 * @param buffer The buffer in question
	 * @param startLine The first line
	 * @param start The start offset, from the beginning of the buffer
	 * @param numLines The number of lines removed
	 * @param length The number of characters removed
	 * @return <code>true</code> if the selection was changed
	 */
abstract boolean contentRemoved(JEditBuffer buffer, int startLine, int start, int numLines, int length);