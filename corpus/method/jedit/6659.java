//}}}
//{{{ getScreenLineOfOffset() method
/**
	 * @param line physical line number of document 
	 * @param offset number of characters from the left of the line. 
	 * @return returns the screen line number where the line and offset are.
	 * It returns -1 if this position is not currently visible
	 */
int getScreenLineOfOffset(int line, int offset) {
    if (lineInfo.length == 0)
        return -1;
    if (line < textArea.getFirstPhysicalLine())
        return -1;
    if (line == textArea.getFirstPhysicalLine() && offset < getLineInfo(0).offset)
        return -1;
    if (line > textArea.getLastPhysicalLine())
        return -1;
    if (line == lastScreenLineP) {
        LineInfo last = getLineInfo(lastScreenLine);
        if (offset >= last.offset && offset < last.offset + last.length) {
            return lastScreenLine;
        }
    }
    int screenLine = -1;
    // Find the screen line containing this offset
    for (int i = 0, n = textArea.getVisibleLines(); i < n; i++) {
        LineInfo info = getLineInfo(i);
        if (info.physicalLine > line) {
            // line is invisible?
            return i - 1;
        //return -1;
        }
        if (info.physicalLine == line) {
            if (offset >= info.offset && offset < info.offset + info.length) {
                screenLine = i;
                break;
            }
        }
    }
    if (screenLine == -1)
        return -1;
    lastScreenLineP = line;
    lastScreenLine = screenLine;
    return screenLine;
}