/**
	 * Sets the caret position without deactivating the selection.
	 * @param newCaret The caret position
	 * @param scrollMode The scroll mode (NO_SCROLL, NORMAL_SCROLL, or
	 * ELECTRIC_SCROLL).
	 * @since jEdit 4.2pre1
	 */
public void moveCaretPosition(int newCaret, int scrollMode) {
    if (newCaret < 0 || newCaret > buffer.getLength()) {
        throw new IllegalArgumentException("caret out of bounds: " + newCaret);
    }
    int oldCaretLine = caretLine;
    if (caret == newCaret)
        finishCaretUpdate(oldCaretLine, scrollMode, false);
    else {
        caret = getCharacterBoundaryAt(newCaret);
        caretLine = getLineOfOffset(caret);
        magicCaret = -1;
        finishCaretUpdate(oldCaretLine, scrollMode, true);
    }
}