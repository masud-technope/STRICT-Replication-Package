//}}}
//{{{ goToNextFold() method
/**
	 * Moves the caret to the next fold.
	 * @param select true if you want to extend selection
	 * @since jEdit 4.0pre3
	 */
public void goToNextFold(boolean select) {
    int nextFold = -1;
    for (int i = caretLine + 1; i < buffer.getLineCount(); i++) {
        if (buffer.isFoldStart(i) && displayManager.isLineVisible(i)) {
            nextFold = i;
            break;
        }
    }
    if (nextFold == -1) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    int magic = getMagicCaretPosition();
    int newCaret = buffer.getLineStartOffset(nextFold) + chunkCache.xToSubregionOffset(nextFold, 0, magic + 1, true);
    if (select)
        extendSelection(caret, newCaret);
    else if (!multi)
        selectNone();
    moveCaretPosition(newCaret);
    setMagicCaretPosition(magic);
}