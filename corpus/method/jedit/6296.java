//}}}
//{{{ replace() method
/**
	 * Replaces the current selection with the replacement string.
	 * @param view The view
	 * @return True if the operation was successful, false otherwise
	 */
public static boolean replace(View view) {
    // component that will parent any dialog boxes
    Component comp = SearchDialog.getSearchDialog(view);
    if (comp == null)
        comp = view;
    JEditTextArea textArea = view.getTextArea();
    Buffer buffer = view.getBuffer();
    if (!buffer.isEditable())
        return false;
    boolean smartCaseReplace = getSmartCaseReplace();
    Selection[] selection = textArea.getSelection();
    if (selection.length == 0) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return false;
    }
    record(view, "replace(view)", true, false);
    // a little hack for reverse replace and find
    int caret = textArea.getCaretPosition();
    Selection s = textArea.getSelectionAtOffset(caret);
    if (s != null)
        caret = s.getStart();
    try {
        buffer.beginCompoundEdit();
        SearchMatcher matcher = getSearchMatcher();
        if (matcher == null)
            return false;
        initReplace();
        int retVal = 0;
        for (Selection aSelection : selection) {
            s = aSelection;
            retVal += replaceInSelection(view, textArea, buffer, matcher, smartCaseReplace, s);
        }
        if (reverse) {
            // so that Replace and Find continues from
            // the right location
            textArea.moveCaretPosition(caret);
        } else {
            s = textArea.getSelectionAtOffset(textArea.getCaretPosition());
            if (s != null)
                textArea.moveCaretPosition(s.getEnd());
        }
        if (!BeanShell.isScriptRunning()) {
            Object[] args = { Integer.valueOf(retVal), Integer.valueOf(1) };
            view.getStatus().setMessageAndClear(jEdit.getProperty("view.status.replace-all", args));
        }
        if (retVal == 0) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return false;
        }
        return true;
    } catch (Exception e) {
        handleError(comp, e);
    } finally {
        buffer.endCompoundEdit();
    }
    return false;
}