//}}}
//}}}
//{{{ Folding
//{{{ goToParentFold() method
/**
	 * Moves the caret to the fold containing the one at the caret
	 * position.
	 * @since jEdit 4.0pre3
	 */
public void goToParentFold() {
    int line = -1;
    int level = buffer.getFoldLevel(caretLine);
    for (int i = caretLine - 1; i >= 0; i--) {
        if (buffer.getFoldLevel(i) < level) {
            line = i;
            break;
        }
    }
    if (line == -1) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    int magic = getMagicCaretPosition();
    int newCaret = buffer.getLineStartOffset(line) + chunkCache.xToSubregionOffset(line, 0, magic + 1, true);
    if (!multi)
        selectNone();
    moveCaretPosition(newCaret);
    setMagicCaretPosition(magic);
}