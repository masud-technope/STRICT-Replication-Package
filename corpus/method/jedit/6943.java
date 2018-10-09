/**
	 * Called when text is inserted into the buffer.
	 * @param buffer The buffer in question
	 * @param startLine The first line
	 * @param start The start offset, from the beginning of the buffer
	 * @param numLines The number of lines inserted
	 * @param length The number of characters inserted
	 * @return <code>true</code> if the selection was changed
	 */
abstract boolean contentInserted(JEditBuffer buffer, int startLine, int start, int numLines, int length);