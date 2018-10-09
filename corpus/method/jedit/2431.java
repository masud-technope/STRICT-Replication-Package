//}}}
//{{{ preContentRemoved() method
/**
	 * Called when text is about to be removed from the buffer, but is
	 * still present.
	 * @param buffer The buffer in question
	 * @param startLine The first line
	 * @param offset The start offset, from the beginning of the buffer
	 * @param numLines The number of lines to be removed
	 * @param length The number of characters to be removed
	 * @since jEdit 4.3pre3
	 */
void preContentRemoved(JEditBuffer buffer, int startLine, int offset, int numLines, int length);