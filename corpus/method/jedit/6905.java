@Override
void preContentRemoved(int startLine, int offset, int numLines) {
    int scrollLines = 0;
    int physicalLine = startLine;
    int numLinesVisible = 0;
    for (int i = 0, n = numLines; i < n; i++, physicalLine++) {
        if (getDisplayManager().isLineVisible(physicalLine)) {
            scrollLines += getDisplayManager().getScreenLineCount(physicalLine);
            numLinesVisible++;
        }
    }
    // process next visible line
    if (!getDisplayManager().isLineVisible(physicalLine))
        physicalLine = getDisplayManager().getNextVisibleLine(physicalLine);
    if (physicalLine >= 0) {
        scrollLines += getDisplayManager().getScreenLineCount(physicalLine);
        numLinesVisible++;
    }
    preContentRemovedScrollLines = scrollLines;
}