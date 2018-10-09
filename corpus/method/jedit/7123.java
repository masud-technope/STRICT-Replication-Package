/**
	 * Extends the selection at the specified offset, or creates a new
	 * one if there is no selection at the specified offset. This is
	 * different from resizing in that the new chunk is added to the
	 * selection in question, instead of replacing it.
	 * @param offset The offset
	 * @param end The new selection end
	 * @param extraStartVirt Extra virtual space at the start
	 * @param extraEndVirt Extra virtual space at the end
	 * @since jEdit 4.2pre1
	 */
public void extendSelection(int offset, int end, int extraStartVirt, int extraEndVirt) {
    offset = getCharacterBoundaryAt(offset);
    end = getCharacterBoundaryAt(end);
    Selection s = getSelectionAtOffset(offset);
    if (s != null) {
        invalidateLineRange(s.startLine, s.endLine);
        selectionManager.removeFromSelection(s);
        if (offset == s.start) {
            offset = end;
            end = s.end;
        } else if (offset == s.end) {
            offset = s.start;
        }
    }
    if (end < offset) {
        int tmp = end;
        end = offset;
        offset = tmp;
    }
    if (rectangularSelectionMode) {
        s = new Selection.Rect(offset, end);
        ((Selection.Rect) s).extraStartVirt = extraStartVirt;
        ((Selection.Rect) s).extraEndVirt = extraEndVirt;
    } else
        s = new Selection.Range(offset, end);
    selectionManager.addToSelection(s);
    fireCaretEvent();
    if (rectangularSelectionMode && extraEndVirt != 0) {
        int line = getLineOfOffset(end);
        scrollTo(line, getLineLength(line) + extraEndVirt, false);
    }
}