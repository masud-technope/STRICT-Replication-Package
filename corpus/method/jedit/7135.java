//}}}
//{{{ removeFromSelection() methods
/**
	 * Deactivates the specified selection.
	 * @param sel The selection
	 * @since jEdit 3.2pre1
	 */
public void removeFromSelection(Selection sel) {
    invalidateSelectedLines();
    selectionManager.removeFromSelection(sel);
    finishCaretUpdate(caretLine, NO_SCROLL, true);
}