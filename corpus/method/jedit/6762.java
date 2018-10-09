//}}}
@Override
void preContentInserted(int startLine, int numLines) {
    int scrollLines = 0;
    int physicalLine = startLine;
    int currentPhysicalLine = getPhysicalLine();
    int numLinesVisible = 0;
    for (int i = 0; physicalLine < currentPhysicalLine; i++, physicalLine++) {
        if (getDisplayManager().isLineVisible(physicalLine)) {
            scrollLines += getDisplayManager().getScreenLineCount(physicalLine);
        }
        if (i < numLines)
            numLinesVisible++;
    }
    preContentInsertedScrollLines = scrollLines;
}