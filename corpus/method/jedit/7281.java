/**
	 * Replaces the selection at the caret with the specified text.
	 * If there is no selection at the caret, the text is inserted at
	 * the caret position.
	 */
public void setSelectedText(String selectedText) {
    int newCaret = replaceSelection(selectedText);
    if (newCaret != -1)
        moveCaretPosition(newCaret);
    selectNone();
}