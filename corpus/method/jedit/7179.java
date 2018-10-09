//}}}
//{{{ selectWord() method
/**
	 * Selects the word at the caret position.
	 * @since jEdit 2.7pre2
	 */
public void selectWord() {
    int line = getCaretLine();
    int lineStart = getLineStartOffset(line);
    int offset = getCaretPosition() - lineStart;
    if (getLineLength(line) == 0)
        return;
    String lineText = getLineText(line);
    String noWordSep = buffer.getStringProperty("noWordSep");
    if (offset == getLineLength(line))
        offset--;
    int wordStart = TextUtilities.findWordStart(lineText, offset, noWordSep, true, false, false);
    int wordEnd = TextUtilities.findWordEnd(lineText, offset + 1, noWordSep, true, false, false);
    Selection s = new Selection.Range(lineStart + wordStart, lineStart + wordEnd);
    if (multi)
        addToSelection(s);
    else
        setSelection(s);
    moveCaretPosition(lineStart + wordEnd);
}