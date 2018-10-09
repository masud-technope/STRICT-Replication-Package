/**
	 * Sets the caret position and deactivates the selection.
	 * @param newCaret The caret position
	 * @param doElectricScroll Do electric scrolling?
	 */
public void setCaretPosition(int newCaret, boolean doElectricScroll) {
    selectNone();
    moveCaretPosition(newCaret, doElectricScroll);
}