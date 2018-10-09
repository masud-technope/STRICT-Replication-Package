//}}}
//{{{ goToEndOfLine() method
/**
	 * Moves the caret to the end of the current line.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2
	 */
public void goToEndOfLine(boolean select) {
    Selection s = getSelectionAtOffset(caret);
    int line = select || s == null ? caretLine : s.endLine;
    int newCaret = getLineEndOffset(line) - 1;
    if (select)
        extendSelection(caret, newCaret);
    else if (!multi)
        selectNone();
    moveCaretPosition(newCaret);
// so that end followed by up arrow will always put caret at
// the end of the previous line, for example
//setMagicCaretPosition(Integer.MAX_VALUE);
}