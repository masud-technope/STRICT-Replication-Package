//}}}
//}}}
//{{{ Undo
//{{{ undo() method
/**
	 * Undoes the most recent edit.
	 * @param textArea the text area
	 * @since jEdit 4.0pre1
	 */
public void undo(TextArea textArea) {
    if (undoMgr == null)
        return;
    if (!isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    try {
        writeLock();
        undoInProgress = true;
        fireBeginUndo();
        Selection[] s = undoMgr.undo();
        if (s == null || s.length == 0)
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        else {
            textArea.setCaretPosition(s[s.length - 1].getEnd());
            textArea.setSelection(s);
        }
        fireEndUndo();
        fireTransactionComplete();
    } finally {
        undoInProgress = false;
        writeUnlock();
    }
}