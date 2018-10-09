//{{{ contentRemoved() method
/**
	 * Method called before a content is removed from a buffer.
	 *
	 * @param startLine the first line of the removed content
	 * @param startOffset the offset in the start line
	 * @param numLines the number of removed lines
	 */
void contentRemoved(int startLine, int startOffset, int numLines) {
    if (Debug.SCROLL_DEBUG)
        Log.log(Log.DEBUG, this, "contentRemoved() before:" + this);
    // The removed content starts before the Anchor, we need to pull the anchor up
    int currentPhysicalLine = getPhysicalLine();
    if (startLine == currentPhysicalLine)
        setCallChanged(true);
    else if (startLine < currentPhysicalLine) {
        int scrollLines = 0;
        int physicalLine = startLine;
        int endLine = currentPhysicalLine - numLines;
        for (; physicalLine < endLine; physicalLine++) {
            if (getDisplayManager().isLineVisible(physicalLine)) {
                scrollLines += getDisplayManager().getScreenLineCount(physicalLine);
            }
        }
        movePhysicalLine(-preContentRemovedNumLines);
        moveScrollLine(scrollLines - preContentRemovedScrollLines);
    }
    if (Debug.SCROLL_DEBUG)
        Log.log(Log.DEBUG, this, "contentRemoved() after:" + this);
    if (Debug.SCROLL_VERIFY)
        scrollVerify();
}