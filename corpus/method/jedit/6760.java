//}}}
@Override
void preContentRemoved(int startLine, int offset, int numLines) {
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
    preContentRemovedScrollLines = scrollLines;
    preContentRemovedNumLines = numLinesVisible;
}