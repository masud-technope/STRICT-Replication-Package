//{{{ getFoldLevel() method
/**
	 * Returns the fold level of the specified line. For a whitespace-only
	 * line, returns the fold level of the next non-whitespace line, or
	 * the level of the previous line if no non-whitespace line follows or if
	 * the level of the previous line is higher.
	 * @param buffer The buffer in question
	 * @param lineIndex The line index
	 * @param seg A segment the fold handler can use to obtain any
	 * text from the buffer, if necessary
	 * @return The fold level of the specified line
	 * @since jEdit 4.0pre1
	 */
public int getFoldLevel(JEditBuffer buffer, int lineIndex, Segment seg) {
    int tabSize = buffer.getTabSize();
    // Look for first non-whitespace line starting at lineIndex
    int prevLevel = 0;
    for (int index = lineIndex; index < buffer.getLineCount(); index++) {
        buffer.getLineText(index, seg);
        int whitespace = getLeadingWhitespaceWidth(seg, tabSize);
        if (// Non-whitespace found on line
        whitespace >= 0)
            return (whitespace > prevLevel) ? whitespace : prevLevel;
        if (index == 0)
            return 0;
        if (index == lineIndex)
            prevLevel = buffer.getFoldLevel(lineIndex - 1);
    }
    // level of previous line.
    return prevLevel;
}