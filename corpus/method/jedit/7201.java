//}}}
//{{{ goToStartOfWhiteSpace() method
/**
	 * Moves the caret to the first non-whitespace character of the current
	 * line.
	 * @param select true if you want to extend selection
	 * @since jEdit 2.7pre2
	 */
public void goToStartOfWhiteSpace(boolean select) {
    if (buffer.isLoading())
        return;
    Selection s = getSelectionAtOffset(caret);
    int line, offset;
    if (select || s == null) {
        line = caretLine;
        offset = caret - buffer.getLineStartOffset(line);
    } else {
        line = s.startLine;
        offset = s.start - buffer.getLineStartOffset(line);
    }
    int firstIndent = chunkCache.getSubregionStartOffset(line, offset);
    if (firstIndent == getLineStartOffset(line)) {
        firstIndent = StandardUtilities.getLeadingWhiteSpace(getLineText(line));
        if (firstIndent == getLineLength(line))
            firstIndent = 0;
        firstIndent += getLineStartOffset(line);
    }
    if (select)
        extendSelection(caret, firstIndent);
    else if (!multi)
        selectNone();
    moveCaretPosition(firstIndent);
}