// }}}
//{{{ setCaretPosition() methods
/**
	 * Sets the caret position and deactivates the selection.
	 * @param newCaret The caret position
	 */
public void setCaretPosition(int newCaret) {
    selectNone();
    moveCaretPosition(newCaret, true);
}