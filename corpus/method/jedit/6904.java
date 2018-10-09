@Override
void contentRemoved(int startLine, int startOffset, int numLines) {
    int scrollLines = 0;
    int physicalLine = startLine;
    if (!getDisplayManager().isLineVisible(physicalLine))
        physicalLine = getDisplayManager().getNextVisibleLine(physicalLine);
    scrollLines = getDisplayManager().getScreenLineCount(physicalLine);
    scrollLines -= preContentRemovedScrollLines;
    movePhysicalLine(-numLines);
    moveScrollLine(scrollLines);
}