/**
	 * Ensures that the specified location in the buffer is visible.
	 * @param line The line number
	 * @param offset The offset from the start of the line
	 * @param doElectricScroll If true, electric scrolling will be performed
	 * @since jEdit 4.0pre6
	 */
public void scrollTo(int line, int offset, boolean doElectricScroll) {
    if (buffer.isLoading())
        return;
    if (Debug.SCROLL_TO_DEBUG)
        Log.log(Log.DEBUG, this, "scrollTo(), lineCount=" + getLineCount());
    if (visibleLines <= 1) {
        if (Debug.SCROLL_TO_DEBUG)
            Log.log(Log.DEBUG, this, "visibleLines <= 0");
        // Fix the case when the line is wrapped
        // it was not possible to see the second (or next)
        // subregion of a line
        ChunkCache.LineInfo[] infos = chunkCache.getLineInfosForPhysicalLine(line);
        int subregion = ChunkCache.getSubregionOfOffset(offset, infos);
        setFirstPhysicalLine(line, subregion);
        return;
    }
    //{{{ Get ready
    int extraEndVirt;
    int lineLength = buffer.getLineLength(line);
    if (offset > lineLength) {
        extraEndVirt = charWidth * (offset - lineLength);
        offset = lineLength;
    } else
        extraEndVirt = 0;
    int _electricScroll = doElectricScroll && visibleLines - 1 > (electricScroll << 1) ? electricScroll : 0;
    //}}}
    //{{{ Scroll vertically
    int screenLine = chunkCache.getScreenLineOfOffset(line, offset);
    int visibleLines = getVisibleLines();
    if (screenLine == -1) {
        // We are scrolling to a position that is not on the screen.
        if (Debug.SCROLL_TO_DEBUG)
            Log.log(Log.DEBUG, this, "screenLine == -1");
        ChunkCache.LineInfo[] infos = chunkCache.getLineInfosForPhysicalLine(line);
        int subregion = ChunkCache.getSubregionOfOffset(offset, infos);
        int prevLine = displayManager.getPrevVisibleLine(getFirstPhysicalLine());
        int nextLine = displayManager.getNextVisibleLine(getLastPhysicalLine());
        if (line == getFirstPhysicalLine()) {
            if (Debug.SCROLL_TO_DEBUG)
                Log.log(Log.DEBUG, this, line + " == " + getFirstPhysicalLine());
            setFirstPhysicalLine(line, subregion - _electricScroll);
        } else if (line == prevLine) {
            if (Debug.SCROLL_TO_DEBUG)
                Log.log(Log.DEBUG, this, line + " == " + prevLine);
            setFirstPhysicalLine(prevLine, subregion - _electricScroll);
        } else if (line == getLastPhysicalLine()) {
            if (Debug.SCROLL_TO_DEBUG)
                Log.log(Log.DEBUG, this, line + " == " + getLastPhysicalLine());
            setFirstPhysicalLine(line, subregion + _electricScroll - visibleLines + (lastLinePartial ? 2 : 1));
        } else if (line == nextLine) {
            if (Debug.SCROLL_TO_DEBUG)
                Log.log(Log.DEBUG, this, line + " == " + nextLine);
            setFirstPhysicalLine(nextLine, subregion + _electricScroll - visibleLines + (lastLinePartial ? 2 : 1));
        } else {
            if (Debug.SCROLL_TO_DEBUG) {
                Log.log(Log.DEBUG, this, "neither");
                Log.log(Log.DEBUG, this, "Last physical line is " + getLastPhysicalLine());
            }
            setFirstPhysicalLine(line, subregion - (visibleLines >> 1));
            if (Debug.SCROLL_TO_DEBUG) {
                Log.log(Log.DEBUG, this, "Last physical line is " + getLastPhysicalLine());
            }
        }
    } else if (screenLine < _electricScroll) {
        if (Debug.SCROLL_TO_DEBUG)
            Log.log(Log.DEBUG, this, "electric up");
        setFirstLine(getFirstLine() - _electricScroll + screenLine);
    } else if (screenLine > visibleLines - _electricScroll - (lastLinePartial ? 2 : 1)) {
        if (Debug.SCROLL_TO_DEBUG)
            Log.log(Log.DEBUG, this, "electric down");
        setFirstLine(getFirstLine() + _electricScroll - visibleLines + screenLine + (lastLinePartial ? 2 : 1));
    //}}}
    }
    //{{{ Scroll horizontally
    if (!displayManager.isLineVisible(line))
        return;
    Point point = offsetToXY(line, offset, offsetXY);
    point.x += extraEndVirt;
    if (point.x < 0) {
        setHorizontalOffset(horizontalOffset - point.x + charWidth + 5);
    } else if (point.x >= painter.getWidth() - charWidth - 5) {
        setHorizontalOffset(horizontalOffset + (painter.getWidth() - point.x) - charWidth - 5);
    //}}}
    }
}