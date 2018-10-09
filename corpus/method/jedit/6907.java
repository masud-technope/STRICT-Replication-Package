//}}}
@Override
void preContentInserted(int startLine, int numLines) {
    preContentInsertedScrollLines = 0;
    int physicalLine = startLine;
    if (!getDisplayManager().isLineVisible(physicalLine))
        physicalLine = getDisplayManager().getNextVisibleLine(physicalLine);
    preContentInsertedScrollLines = getDisplayManager().getScreenLineCount(physicalLine);
}