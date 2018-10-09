/**
	 * Used when doing S+UP/DOWN to simplify dealing with virtual space.
	 */
private RectParams getRectParams(int caret, int newCaret) {
    Selection s = getSelectionAtOffset(caret);
    int virtualWidth;
    if (s instanceof Selection.Rect) {
        if (caret == s.end) {
            virtualWidth = buffer.getVirtualWidth(s.endLine, s.end - getLineStartOffset(s.endLine)) + ((Selection.Rect) s).extraEndVirt;
        } else {
            virtualWidth = buffer.getVirtualWidth(s.startLine, s.start - getLineStartOffset(s.startLine)) + ((Selection.Rect) s).extraStartVirt;
        }
    } else if (rectangularSelectionMode) {
        virtualWidth = buffer.getVirtualWidth(caretLine, caret - buffer.getLineStartOffset(caretLine));
    } else
        return null;
    int newLine = getLineOfOffset(newCaret);
    int[] totalVirtualWidth = new int[1];
    int newOffset = buffer.getOffsetOfVirtualColumn(newLine, virtualWidth, totalVirtualWidth);
    if (newOffset == -1) {
        int extraVirt = virtualWidth - totalVirtualWidth[0];
        newCaret = getLineEndOffset(newLine) - 1;
        boolean bias;
        if (s == null)
            bias = newCaret < caret;
        else if (s.start == caret)
            bias = newCaret <= s.end;
        else if (s.end == caret)
            bias = newCaret <= s.start;
        else
            bias = false;
        RectParams returnValue;
        if (bias)
            returnValue = new RectParams(extraVirt, 0, newCaret);
        else
            returnValue = new RectParams(0, extraVirt, newCaret);
        return returnValue;
    } else {
        return new RectParams(0, 0, getLineStartOffset(newLine) + newOffset);
    }
}