//}}}
//{{{ moveCaretPosition() methods
/**
	 * Sets the caret position without deactivating the selection.
	 * @param newCaret The caret position
	 */
public void moveCaretPosition(int newCaret) {
    moveCaretPosition(newCaret, true);
}