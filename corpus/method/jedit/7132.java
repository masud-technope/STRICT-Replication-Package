/**
	 * Deactivates the selection at the specified offset. If there is
	 * no selection at that offset, does nothing.
	 * @param offset The offset
	 * @since jEdit 3.2pre1
	 */
public void removeFromSelection(int offset) {
    Selection sel = getSelectionAtOffset(offset);
    if (sel == null)
        return;
    invalidateSelectedLines();
    selectionManager.removeFromSelection(sel);
    finishCaretUpdate(caretLine, NO_SCROLL, true);
}