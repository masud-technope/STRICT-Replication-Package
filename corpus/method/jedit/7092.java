//}}}
//{{{ toUpperCase() method
/**
	 * Converts the selected text to upper case.
	 * @since jEdit 2.7pre2
	 */
public void toUpperCase() {
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
    for (Selection s : selection) setSelectedText(s, getSelectedText(s).toUpperCase());
    buffer.endCompoundEdit();
    if (caret != -1)
        setCaretPosition(caret);
}