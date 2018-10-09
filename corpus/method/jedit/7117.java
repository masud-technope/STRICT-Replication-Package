/**
	 * Sets the selection. Nested and overlapping selections are merged
	 * where possible.
	 * @param selection The new selection
	 * since jEdit 3.2pre1
	 */
public void setSelection(Selection selection) {
    invalidateSelectedLines();
    selectionManager.setSelection(selection);
    finishCaretUpdate(caretLine, NO_SCROLL, true);
}