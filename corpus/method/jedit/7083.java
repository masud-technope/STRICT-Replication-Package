//}}}
//{{{ addExplicitFold() method
/**
	 * Surrounds the selection with explicit fold markers.
	 * @throws TextAreaException an exception thrown if the folding mode is
	 * not explicit
	 * @since jEdit 4.0pre3
	 */
public void addExplicitFold() throws TextAreaException {
    if (!buffer.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    if (!"explicit".equals(buffer.getStringProperty("folding"))) {
        throw new TextAreaException("folding-not-explicit");
    }
    try {
        buffer.beginCompoundEdit();
        if (getSelectionCount() == 0) {
            int caretBack = addExplicitFold(caret, caret, caretLine, caretLine);
            setCaretPosition(caret - caretBack);
        } else {
            Selection[] selections = getSelection();
            Selection selection = null;
            int caretBack = 0;
            for (Selection selection1 : selections) {
                selection = selection1;
                caretBack = addExplicitFold(selection.start, selection.end, selection.startLine, selection.endLine);
            }
            // Selection cannot be null because there is at least 1 selection
            assert selection != null;
            setCaretPosition(selection.start - caretBack, false);
        }
    } finally {
        buffer.endCompoundEdit();
    }
}