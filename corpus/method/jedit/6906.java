@Override
void contentInserted(int startLine, int numLines) {
    int scrollLines = 0;
    int physicalLine = startLine;
    for (int i = 0, n = numLines; i < n; i++, physicalLine++) {
        if (getDisplayManager().isLineVisible(physicalLine))
            scrollLines += getDisplayManager().getScreenLineCount(physicalLine);
    }
    // process next visible line
    if (!getDisplayManager().isLineVisible(physicalLine))
        physicalLine = getDisplayManager().getNextVisibleLine(physicalLine);
    if (physicalLine >= 0)
        scrollLines += getDisplayManager().getScreenLineCount(physicalLine);
    scrollLines -= preContentInsertedScrollLines;
    movePhysicalLine(numLines);
    moveScrollLine(scrollLines);
}