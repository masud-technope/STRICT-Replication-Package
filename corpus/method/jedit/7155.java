//}}}
//{{{ goToPrevCharacter() method
/**
	 * Moves the caret to the previous character.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2.
	 */
public void goToPrevCharacter(boolean select) {
    Selection s = getSelectionAtOffset(caret);
    if (!select && s instanceof Selection.Range) {
        if (multi) {
            if (caret != s.start) {
                moveCaretPosition(s.start);
                return;
            }
        } else {
            setCaretPosition(s.start);
            return;
        }
    }
    if (caret == 0) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    int extraStartVirt = 0;
    int extraEndVirt = 0;
    int newCaret = caret;
    if (select && caret == getLineEndOffset(caretLine) - 1) {
        if (s instanceof Selection.Rect) {
            extraStartVirt = ((Selection.Rect) s).extraStartVirt;
            extraEndVirt = ((Selection.Rect) s).extraEndVirt;
            if (caret == s.start) {
                if (extraStartVirt == 0)
                    newCaret = getPrevCharacterOffset(caret);
                else
                    extraStartVirt--;
            } else {
                if (extraEndVirt == 0)
                    newCaret = getPrevCharacterOffset(caret);
                else
                    extraEndVirt--;
            }
        } else
            newCaret = getPrevCharacterOffset(caret);
    } else if (caret == getLineStartOffset(caretLine)) {
        int line = displayManager.getPrevVisibleLine(caretLine);
        if (line == -1) {
            javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
            return;
        }
        newCaret = getLineEndOffset(line) - 1;
    } else
        newCaret = getPrevCharacterOffset(caret);
    if (select)
        extendSelection(caret, newCaret, extraStartVirt, extraEndVirt);
    else if (!multi)
        selectNone();
    moveCaretPosition(newCaret);
}