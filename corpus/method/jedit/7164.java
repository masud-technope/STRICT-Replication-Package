//}}}
//{{{ goToPrevLine() method
/**
	 * Moves the caret to the previous line.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2
	 */
public void goToPrevLine(boolean select) {
    Selection s = getSelectionAtOffset(caret);
    boolean rectSelect = s == null ? rectangularSelectionMode : s instanceof Selection.Rect;
    int magic = getMagicCaretPosition();
    int newCaret = chunkCache.getAbovePosition(caretLine, caret - buffer.getLineStartOffset(caretLine), magic + 1, rectSelect && select);
    if (newCaret == -1) {
        int start = getLineStartOffset(caretLine);
        if (caret == start) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return;
        } else
            newCaret = start;
    }
    _changeLine(select, newCaret);
    setMagicCaretPosition(magic);
}