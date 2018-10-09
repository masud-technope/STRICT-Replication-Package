//}}}
//{{{ removeTrailingWhiteSpace() method
/**
	 * Removes trailing whitespace from all lines in the selection.
	 * @since jEdit 2.7pre2
	 */
public void removeTrailingWhiteSpace() {
    if (!buffer.isEditable())
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
    else {
        buffer.removeTrailingWhiteSpace(getSelectedLines());
    }
}