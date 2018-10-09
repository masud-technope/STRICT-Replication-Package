/**
	 * Replaces the selection at the caret with the specified text.
	 * If there is no selection at the caret, the text is inserted at
	 * the caret position.
	 * @param selectedText The new selection
	 * @param moveCaret Move caret to insertion location if necessary
	 * @since jEdit 4.2pre5
	 */
public void setSelectedText(String selectedText, boolean moveCaret) {
    int newCaret = replaceSelection(selectedText);
    if (moveCaret && newCaret != -1)
        moveCaretPosition(newCaret);
    selectNone();
}