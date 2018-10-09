//}}}
//{{{ selectParagraph() method
/**
	 * Selects the paragraph at the caret position.
	 * @since jEdit 2.7pre2
	 */
public void selectParagraph() {
    int caretLine = getCaretLine();
    if (getLineLength(caretLine) == 0) {
        javax.swing.UIManager.getLookAndFeel().provideErrorFeedback(null);
        return;
    }
    int start = caretLine;
    int end = caretLine;
    while (start >= 0) {
        if (getLineLength(start) == 0)
            break;
        else
            start--;
    }
    while (end < getLineCount()) {
        if (getLineLength(end) == 0)
            break;
        else
            end++;
    }
    int selectionStart = getLineStartOffset(start + 1);
    int selectionEnd = getLineEndOffset(end - 1) - 1;
    Selection s = new Selection.Range(selectionStart, selectionEnd);
    if (multi)
        addToSelection(s);
    else
        setSelection(s);
    moveCaretPosition(selectionEnd);
}