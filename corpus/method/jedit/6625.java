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
public void preContentRemoved(JEditBuffer buffer, int startLine, int offset, int numLines, int length) {
    if (buffer.isLoading())
        return;
    FirstLine firstLine = displayManager.firstLine;
    ScrollLineCount scrollLineCount = displayManager.scrollLineCount;
    if (textArea.getDisplayManager() == displayManager) {
        if (numLines == 0) {
            getReadyToBreakFold(startLine);
        } else {
            int lastLine = startLine + numLines;
            if (!displayManager.isLineVisible(startLine) || !displayManager.isLineVisible(lastLine) || offset != buffer.getLineStartOffset(startLine) || offset + length != buffer.getLineStartOffset(lastLine)) {
                getReadyToBreakFold(startLine);
                getReadyToBreakFold(lastLine);
            } else {
            // The removal will not touch
            // inside of folds and will not
            // modify any remaining lines.
            }
        }
        firstLine.preContentRemoved(startLine, offset, numLines);
        scrollLineCount.preContentRemoved(startLine, offset, numLines);
        if (delayedUpdateEnd >= startLine)
            delayedUpdateEnd -= numLines;
        delayUpdate(startLine, startLine);
    } else {
        firstLine.setCallReset(true);
        scrollLineCount.setCallReset(true);
    }
    displayManager.screenLineMgr.contentRemoved(startLine, numLines);
    if (numLines == 0)
        return;
    delayedMultilineUpdate = true;
    if (displayManager.folds.preContentRemoved(startLine, numLines)) {
        displayManager.folds.reset(buffer.getLineCount());
        firstLine.setCallReset(true);
        scrollLineCount.setCallReset(true);
    }
    if (firstLine.getPhysicalLine() > displayManager.getLastVisibleLine() || firstLine.getPhysicalLine() < displayManager.getFirstVisibleLine()) {
    // will be handled later.
    // see comments at the end of
    // transactionComplete().
    }
}