//}}}
//{{{ getUpdateStartLine() method
/**
	 * Return a physical line number.
	 */
private int getUpdateStartLine(int firstScreenLine) {
    // the text area's first physical line
    if (firstScreenLine == 0) {
        return textArea.getFirstPhysicalLine();
    } else // otherwise, determine the next visible line
    {
        int prevPhysLine = lineInfo[firstScreenLine - 1].physicalLine;
        // when the buffer has less lines than are visible
        if (prevPhysLine == -1)
            return -1;
        else {
            return textArea.displayManager.getNextVisibleLine(prevPhysLine);
        }
    }
}