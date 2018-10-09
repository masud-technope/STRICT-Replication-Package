//}}}
//{{{ getPrecedingFoldLevels() method
/**
	 * Returns the fold levels of the lines preceding the specified line,
	 * which depend on the specified line.
	 * @param buffer The buffer in question
	 * @param lineIndex The line index
	 * @param seg A segment the fold handler can use to obtain any
	 * @param lineFoldLevel The fold level of the specified line
	 * @return The fold levels of the preceding lines, in decreasing line
	 * number order (i.e. bottomost line first).
	 * @since jEdit 4.3pre18
	 */
public List<Integer> getPrecedingFoldLevels(JEditBuffer buffer, int lineIndex, Segment seg, int lineFoldLevel) {
    List<Integer> precedingFoldLevels = new ArrayList<Integer>();
    int tabSize = buffer.getTabSize();
    int whitespace = 0;
    int index;
    // Find previous non-whitespace-only line
    for (index = lineIndex - 1; index > 0; index--) {
        buffer.getLineText(index, seg);
        whitespace = getLeadingWhitespaceWidth(seg, tabSize);
        if (whitespace >= 0)
            break;
    }
    int max = (lineFoldLevel > whitespace) ? lineFoldLevel : whitespace;
    for (index++; index < lineIndex; index++) precedingFoldLevels.add(Integer.valueOf(max));
    return precedingFoldLevels;
}