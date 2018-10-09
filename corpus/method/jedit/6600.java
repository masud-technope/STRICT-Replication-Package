//}}}
//{{{ preContentRemoved() method
/**
	 * Method called before a content is removed from a buffer.
	 *
	 * @param startLine the first line of the removed content
	 * @param offset the offset in the start line
	 * @param numLines the number of removed lines
	 */
abstract void contentRemoved(int startLine, int offset, int numLines);