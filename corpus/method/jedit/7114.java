//}}}
//{{{ addToSelection() methods
/**
	 * Adds to the selection. Nested and overlapping selections are merged
	 * where possible.
	 * @param selection The new selection
	 * since jEdit 3.2pre1
	 */
public void addToSelection(Selection[] selection) {
    invalidateSelectedLines();
    selectionManager.addToSelection(selection);
    finishCaretUpdate(caretLine, NO_SCROLL, true);
}