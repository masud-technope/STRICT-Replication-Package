//}}}
//{{{ goToNextLine() method
/**
	 * Move the caret to the next line.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2
	 */
public void goToNextLine(boolean select) {
    Selection s = getSelectionAtOffset(caret);
    boolean rectSelect = s == null ? rectangularSelectionMode : s instanceof Selection.Rect;
    int magic = getMagicCaretPosition();
    int newCaret = chunkCache.getBelowPosition(caretLine, caret - buffer.getLineStartOffset(caretLine), magic + 1, rectSelect && select);
    if (newCaret == -1) {
        int end = getLineEndOffset(caretLine) - 1;
        if (caret == end) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return;
        } else
            newCaret = end;
    }
    _changeLine(select, newCaret);
    setMagicCaretPosition(magic);
}