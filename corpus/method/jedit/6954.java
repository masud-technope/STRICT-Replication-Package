//}}}
//{{{ getSelectionStartEndOnLine() method
/**
	 * Returns the x co-ordinates of the selection start and end on the
	 * given line. May return null.
	 */
int[] getSelectionStartAndEnd(int screenLine, int physicalLine, Selection s) {
    int start = textArea.getScreenLineStartOffset(screenLine);
    int end = textArea.getScreenLineEndOffset(screenLine);
    if (end <= s.start || start > s.end)
        return null;
    int selStartScreenLine;
    if (textArea.displayManager.isLineVisible(s.startLine))
        selStartScreenLine = textArea.getScreenLineOfOffset(s.start);
    else
        selStartScreenLine = -1;
    int selEndScreenLine;
    if (textArea.displayManager.isLineVisible(s.endLine))
        selEndScreenLine = textArea.getScreenLineOfOffset(s.end);
    else
        selEndScreenLine = -1;
    JEditBuffer buffer = textArea.getBuffer();
    int lineStart = buffer.getLineStartOffset(physicalLine);
    int x1, x2;
    if (s instanceof Selection.Rect) {
        start -= lineStart;
        end -= lineStart;
        Selection.Rect rect = (Selection.Rect) s;
        int _start = rect.getStartColumn(buffer);
        int _end = rect.getEndColumn(buffer);
        int lineLen = buffer.getLineLength(physicalLine);
        int[] total = new int[1];
        int rectStart = buffer.getOffsetOfVirtualColumn(physicalLine, _start, total);
        if (rectStart == -1) {
            x1 = (_start - total[0]) * textArea.charWidth;
            rectStart = lineLen;
        } else
            x1 = 0;
        int rectEnd = buffer.getOffsetOfVirtualColumn(physicalLine, _end, total);
        if (rectEnd == -1) {
            x2 = (_end - total[0]) * textArea.charWidth;
            rectEnd = lineLen;
        } else
            x2 = 0;
        if (end <= rectStart || start > rectEnd)
            return null;
        x1 = rectStart < start ? 0 : x1 + textArea.offsetToXY(physicalLine, rectStart).x;
        x2 = rectEnd > end ? textArea.getWidth() : x2 + textArea.offsetToXY(physicalLine, rectEnd).x;
    } else if (selStartScreenLine == selEndScreenLine && selStartScreenLine != -1) {
        x1 = textArea.offsetToXY(physicalLine, s.start - lineStart).x;
        x2 = textArea.offsetToXY(physicalLine, s.end - lineStart).x;
    } else if (screenLine == selStartScreenLine) {
        x1 = textArea.offsetToXY(physicalLine, s.start - lineStart).x;
        x2 = textArea.getWidth();
    } else if (screenLine == selEndScreenLine) {
        x1 = 0;
        x2 = textArea.offsetToXY(physicalLine, s.end - lineStart).x;
    } else {
        x1 = 0;
        x2 = textArea.getWidth();
    }
    if (x1 < 0)
        x1 = 0;
    if (x2 < 0)
        x2 = 0;
    if (x1 == x2)
        x2++;
    return new int[] { x1, x2 };
}