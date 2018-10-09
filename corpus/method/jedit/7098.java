//}}}
//{{{ toLowerCase() method
/**
	 * Converts the selected text to lower case.
	 * @since jEdit 2.7pre2
	 */
public void toLowerCase() {
    if (!buffer.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    Selection[] selection = getSelection();
    int caret = -1;
    if (selection.length == 0) {
        caret = getCaretPosition();
        selectWord();
        selection = getSelection();
    }
    if (selection.length == 0) {
        if (caret != -1)
            setCaretPosition(caret);
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    buffer.beginCompoundEdit();
    for (Selection s : selection) setSelectedText(s, getSelectedText(s).toLowerCase());
    buffer.endCompoundEdit();
    if (caret != -1)
        setCaretPosition(caret);
}