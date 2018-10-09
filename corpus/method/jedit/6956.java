//}}}
//{{{ insideSelection() method
/**
	 * Returns if the given point is inside a selection.
	 * Used by drag and drop code in MouseHandler below.
	 */
boolean insideSelection(int x, int y) {
    int offset = textArea.xyToOffset(x, y);
    Selection s = textArea.getSelectionAtOffset(offset);
    if (s == null)
        return false;
    int screenLine = textArea.getScreenLineOfOffset(offset);
    if (screenLine == -1)
        return false;
    int[] selectionStartAndEnd = getSelectionStartAndEnd(screenLine, textArea.getLineOfOffset(offset), s);
    if (selectionStartAndEnd == null)
        return false;
    return x >= selectionStartAndEnd[0] && x <= selectionStartAndEnd[1];
}