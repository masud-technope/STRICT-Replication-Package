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
	 */
void resizeSelection(int offset, int end, int extraEndVirt, boolean rect) {
    boolean reversed = false;
    if (end < offset) {
        int tmp = offset;
        offset = end;
        end = tmp;
        reversed = true;
    }
    Selection newSel;
    if (rect) {
        Selection.Rect rectSel = new Selection.Rect(offset, end);
        if (reversed)
            rectSel.extraStartVirt = extraEndVirt;
        else
            rectSel.extraEndVirt = extraEndVirt;
        newSel = rectSel;
    } else
        newSel = new Selection.Range(offset, end);
    addToSelection(newSel);
}