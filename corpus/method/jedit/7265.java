//}}}
//{{{ replaceSelection() method
/**
	 * Set the selection, but does not deactivate it, and does not move the
	 * caret.
	 *
	 * Please use {@link #setSelectedText(String)} instead.
	 *
	 * @param selectedText The new selection
	 * @return The new caret position
	 * @since 4.3pre1
	 */
public int replaceSelection(String selectedText) {
    if (!isEditable())
        throw new RuntimeException("Text component read only");
    int newCaret = -1;
    if (getSelectionCount() == 0) {
        // for compatibility with older jEdit versions
        buffer.insert(caret, selectedText);
    } else {
        try {
            buffer.beginCompoundEdit();
            Selection[] selection = getSelection();
            for (Selection aSelection : selection) newCaret = aSelection.setText(buffer, selectedText);
        } finally {
            buffer.endCompoundEdit();
        }
    }
    return newCaret;
}