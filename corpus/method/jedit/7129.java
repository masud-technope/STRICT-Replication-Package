//}}}
//{{{ resizeSelection() method
/**
	 * Resizes the selection at the specified offset, or creates a new
	 * one if there is no selection at the specified offset. This is a
	 * utility method that is mainly useful in the mouse event handler
	 * because it handles the case of end being before offset gracefully
	 * (unlike the rest of the selection API).
	 * @param offset The offset
	 * @param end The new selection end
	 * @param extraEndVirt Only for rectangular selections - specifies how
	 * far it extends into virtual space.
	 * @param rect Make the selection rectangular?
	 * @since jEdit 3.2pre1
	 */
public void resizeSelection(int offset, int end, int extraEndVirt, boolean rect) {
    Selection s = selectionManager.getSelectionAtOffset(offset);
    if (s != null) {
        invalidateLineRange(s.startLine, s.endLine);
        selectionManager.removeFromSelection(s);
    }
    selectionManager.resizeSelection(offset, end, extraEndVirt, rect);
    fireCaretEvent();
}