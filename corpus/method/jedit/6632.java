//}}}
//{{{ getBelowPosition() method
/**
	 * @param physicalLine The physical line number
	 * @param offset The offset
	 * @param x The location
	 * @param ignoreWrap If true, behave as if soft wrap is off even if it
	 * is on
	 */
int getBelowPosition(int physicalLine, int offset, int x, boolean ignoreWrap) {
    LineInfo[] lineInfos = getLineInfosForPhysicalLine(physicalLine);
    int subregion = getSubregionOfOffset(offset, lineInfos);
    if (subregion != lineInfos.length - 1 && !ignoreWrap) {
        return textArea.getLineStartOffset(physicalLine) + xToSubregionOffset(lineInfos[subregion + 1], x, true);
    } else {
        int nextLine = textArea.displayManager.getNextVisibleLine(physicalLine);
        if (nextLine == -1)
            return -1;
        else {
            return textArea.getLineStartOffset(nextLine) + xToSubregionOffset(nextLine, 0, x, true);
        }
    }
}