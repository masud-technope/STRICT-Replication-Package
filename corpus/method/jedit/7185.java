//}}}
//{{{ selectLine() method
/**
	 * Selects the current line.
	 * @since jEdit 2.7pre2
	 */
public void selectLine() {
    int caretLine = getCaretLine();
    int start = getLineStartOffset(caretLine);
    int end = getLineEndOffset(caretLine) - 1;
    Selection s = new Selection.Range(start, end);
    if (multi)
        addToSelection(s);
    else
        setSelection(s);
    moveCaretPosition(end);
}