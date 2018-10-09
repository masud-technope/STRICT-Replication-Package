//}}}
//{{{ preContentInserted() method
/**
	 * Called when text is about to be inserted in the buffer.
	 * @param buffer The buffer in question
	 * @param startLine The first line
	 * @param offset The start offset, from the beginning of the buffer
	 * @param numLines The number of lines inserted
	 * @param length The number of characters inserted
	 * @since jEdit 4.3pre11
	 */
public void preContentInserted(JEditBuffer buffer, int startLine, int offset, int numLines, int length) {
    if (buffer.isLoading())
        return;
    if (textArea.getDisplayManager() == displayManager) {
        getReadyToBreakFold(startLine);
        displayManager.firstLine.preContentInserted(startLine, numLines);
        displayManager.scrollLineCount.preContentInserted(startLine, numLines);
    }
}