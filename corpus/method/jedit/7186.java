//}}}
//{{{ goToStartOfLine() method
/**
	 * Moves the caret to the beginning of the current line.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2
	 */
public void goToStartOfLine(boolean select) {
    Selection s = getSelectionAtOffset(caret);
    int line = select || s == null ? caretLine : s.startLine;
    int newCaret = getLineStartOffset(line);
    if (select)
        extendSelection(caret, newCaret);
    else if (!multi)
        selectNone();
    moveCaretPosition(newCaret);
}