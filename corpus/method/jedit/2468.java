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
    return null;
}