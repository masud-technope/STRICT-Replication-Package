//}}}
//{{{ getAbovePosition() method
/**
	 * @param physicalLine The physical line number
	 * @param offset The offset
	 * @param x The location
	 * @param ignoreWrap If true, behave as if soft wrap is off even if it
	 * is on
	 */
int getAbovePosition(int physicalLine, int offset, int x, boolean ignoreWrap) {
    LineInfo[] lineInfos = getLineInfosForPhysicalLine(physicalLine);
    int subregion = getSubregionOfOffset(offset, lineInfos);
    if (subregion != 0 && !ignoreWrap) {
        return textArea.getLineStartOffset(physicalLine) + xToSubregionOffset(lineInfos[subregion - 1], x, true);
    } else {
        int prevLine = textArea.displayManager.getPrevVisibleLine(physicalLine);
        if (prevLine == -1)
            return -1;
        else {
            return textArea.getLineStartOffset(prevLine) + xToSubregionOffset(prevLine, -1, x, true);
        }
    }
}