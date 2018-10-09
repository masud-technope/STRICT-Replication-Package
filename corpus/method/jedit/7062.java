//}}}
//{{{ goToPrevFold() method
/**
	 * Moves the caret to the previous fold.
	 * @param select true if you want to extend selection
	 * @since jEdit 4.0pre3
	 */
public void goToPrevFold(boolean select) {
    int prevFold = -1;
    for (int i = caretLine - 1; i >= 0; i--) {
        if (buffer.isFoldStart(i) && displayManager.isLineVisible(i)) {
            prevFold = i;
            break;
        }
    }
    if (prevFold == -1) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    int magic = getMagicCaretPosition();
    int newCaret = buffer.getLineStartOffset(prevFold) + chunkCache.xToSubregionOffset(prevFold, 0, magic + 1, true);
    if (select)
        extendSelection(caret, newCaret);
    else if (!multi)
        selectNone();
    moveCaretPosition(newCaret);
    setMagicCaretPosition(magic);
}