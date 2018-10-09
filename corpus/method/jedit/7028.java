//}}}
//{{{ deleteToStartOfLine() method
/**
	 * Deletes from the caret to the beginning of the current line.
	 * @since jEdit 2.7pre2
	 */
public void deleteToStartOfLine() {
    if (!buffer.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    buffer.remove(getLineStartOffset(caretLine), caret - getLineStartOffset(caretLine));
}