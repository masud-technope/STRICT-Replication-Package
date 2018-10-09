//}}}
//{{{ goToEndOfWhiteSpace() method
/**
	 * Moves the caret to the last non-whitespace character of the current
	 * line.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2
	 */
public void goToEndOfWhiteSpace(boolean select) {
    if (buffer.isLoading())
        return;
    Selection s = getSelectionAtOffset(caret);
    int line, offset;
    if (select || s == null) {
        line = caretLine;
        offset = caret - getLineStartOffset(line);
    } else {
        line = s.endLine;
        offset = s.end - getLineStartOffset(line);
    }
    int lastIndent = chunkCache.getSubregionEndOffset(line, offset);
    if (lastIndent == getLineEndOffset(line)) {
        lastIndent = getLineLength(line) - StandardUtilities.getTrailingWhiteSpace(getLineText(line));
        if (lastIndent == 0)
            lastIndent = getLineLength(line);
        lastIndent += getLineStartOffset(line);
    } else {
        lastIndent--;
    }
    if (select)
        extendSelection(caret, lastIndent);
    else if (!multi)
        selectNone();
    moveCaretPosition(lastIndent);
}