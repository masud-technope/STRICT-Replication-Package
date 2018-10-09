//}}}
//{{{ redo() method
/**
	 * Redoes the most recently undone edit.
	 * @param textArea the textArea
	 * @since jEdit 2.7pre2
	 */
public void redo(TextArea textArea) {
    if (undoMgr == null)
        return;
    if (!isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    try {
        writeLock();
        undoInProgress = true;
        fireBeginRedo();
        Selection[] s = undoMgr.redo();
        if (s == null || s.length == 0)
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        else {
            textArea.setCaretPosition(s[s.length - 1].getEnd());
            textArea.setSelection(s);
        }
        fireEndRedo();
        fireTransactionComplete();
    } finally {
        undoInProgress = false;
        writeUnlock();
    }
}