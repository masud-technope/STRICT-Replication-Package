//}}}
//{{{ contentInserted() method
/**
	 * Called when text is inserted into the buffer.
	 * @param buffer The buffer in question
	 * @param startLine The first line
	 * @param offset The start offset, from the beginning of the buffer
	 * @param numLines The number of lines inserted
	 * @param length The number of characters inserted
	 * @since jEdit 4.3pre3
	 */
void contentInserted(JEditBuffer buffer, int startLine, int offset, int numLines, int length);