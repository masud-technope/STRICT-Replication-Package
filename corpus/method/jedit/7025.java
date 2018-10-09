//}}}
//{{{ deleteToEndOfLine() method
/**
	 * Deletes from the caret to the end of the current line.
	 * @since jEdit 2.7pre2
	 */
public void deleteToEndOfLine() {
    if (!buffer.isEditable()) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    buffer.remove(caret, getLineEndOffset(caretLine) - caret - 1);
}