//}}}
//{{{ goToNextCharacter() method
/**
	 * Moves the caret to the next character.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2.
	 */
public void goToNextCharacter(boolean select) {
    Selection s = getSelectionAtOffset(caret);
    if (!select && s instanceof Selection.Range) {
        if (multi) {
            if (caret != s.end) {
                moveCaretPosition(s.end);
                return;
            }
        } else {
            setCaretPosition(s.end);
            return;
        }
    }
    int extraStartVirt, extraEndVirt;
    if (s instanceof Selection.Rect) {
        extraStartVirt = ((Selection.Rect) s).extraStartVirt;
        extraEndVirt = ((Selection.Rect) s).extraEndVirt;
    } else {
        extraStartVirt = 0;
        extraEndVirt = 0;
    }
    int newCaret = caret;
    if (caret == buffer.getLength()) {
        if (select && (rectangularSelectionMode || s instanceof Selection.Rect)) {
            if (s != null && caret == s.start)
                extraStartVirt++;
            else
                extraEndVirt++;
        } else {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return;
        }
    } else if (caret == getLineEndOffset(caretLine) - 1) {
        if (select && (rectangularSelectionMode || s instanceof Selection.Rect)) {
            if (s != null && caret == s.start)
                extraStartVirt++;
            else
                extraEndVirt++;
        } else {
            int line = displayManager.getNextVisibleLine(caretLine);
            if (line == -1) {
                javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
                return;
            } else
                newCaret = getLineStartOffset(line);
        }
    } else
        newCaret = getNextCharacterOffset(caret);
    if (select)
        extendSelection(caret, newCaret, extraStartVirt, extraEndVirt);
    else if (!multi)
        selectNone();
    moveCaretPosition(newCaret);
}