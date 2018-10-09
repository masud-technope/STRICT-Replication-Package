//{{{ contentInserted() method
/**
	 * Some content is inserted.
	 *
	 * @param startLine the start of the insert
	 * @param numLines the number of inserted lines
	 */
void contentInserted(int startLine, int numLines) {
    if (Debug.SCROLL_DEBUG)
        Log.log(Log.DEBUG, this, "contentInserted() before:" + this);
    int currentPhysicalLine = getPhysicalLine();
    // The Anchor is changed only if the content was inserted before
    if (startLine == currentPhysicalLine)
        setCallChanged(true);
    else if (startLine < currentPhysicalLine) {
        int scrollLines = 0;
        int physicalLine = startLine;
        int endLine = currentPhysicalLine + numLines;
        int numLinesVisible = 0;
        for (int i = 0; physicalLine < endLine; physicalLine++, i++) {
            if (getDisplayManager().isLineVisible(physicalLine)) {
                scrollLines += getDisplayManager().getScreenLineCount(physicalLine);
            }
            if (i < numLines)
                numLinesVisible++;
        }
        movePhysicalLine(numLinesVisible);
        moveScrollLine(scrollLines - preContentInsertedScrollLines);
    }
    if (Debug.SCROLL_DEBUG)
        Log.log(Log.DEBUG, this, "contentInserted() after:" + this);
    if (Debug.SCROLL_VERIFY)
        scrollVerify();
}