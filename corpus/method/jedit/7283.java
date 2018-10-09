/**
	 * Sets the caret position without deactivating the selection.
	 * @param newCaret The caret position
	 * @param doElectricScroll Do electric scrolling?
	 */
public void moveCaretPosition(int newCaret, boolean doElectricScroll) {
    moveCaretPosition(newCaret, doElectricScroll ? ELECTRIC_SCROLL : NORMAL_SCROLL);
}