/**
	 * Selects the fold that contains the specified line number.
	 * @param line The line number
	 * @since jEdit 4.0pre1
	 */
public void selectFold(int line) {
    int[] lines = buffer.getFoldAtLine(line);
    int newCaret = getLineEndOffset(lines[1]) - 1;
    Selection s = new Selection.Range(getLineStartOffset(lines[0]), newCaret);
    if (multi)
        addToSelection(s);
    else
        setSelection(s);
    moveCaretPosition(newCaret);
}