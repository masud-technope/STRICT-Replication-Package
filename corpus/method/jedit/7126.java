//}}}
//{{{ extendSelection() methods
/**
	 * Extends the selection at the specified offset, or creates a new
	 * one if there is no selection at the specified offset. This is
	 * different from resizing in that the new chunk is added to the
	 * selection in question, instead of replacing it.
	 * @param offset The offset
	 * @param end The new selection end
	 * @since jEdit 3.2pre1
	 */
public void extendSelection(int offset, int end) {
    extendSelection(offset, end, 0, 0);
}