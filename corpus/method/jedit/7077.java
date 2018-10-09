//}}}
//{{{ narrowToSelection() method
/**
	 * Hides all lines except those in the selection.
	 * @since jEdit 4.0pre1
	 */
public void narrowToSelection() {
    if (getSelectionCount() != 1) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    Selection sel = getSelection(0);
    displayManager.narrow(sel.getStartLine(), sel.getEndLine());
    selectNone();
}