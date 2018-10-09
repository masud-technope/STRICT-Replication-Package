//}}}
//{{{ narrow() method
/**
	 * Narrows the visible portion of the buffer to the specified
	 * line range.
	 * @param start The first line
	 * @param end The last line
	 * @since jEdit 4.2pre1
	 */
public void narrow(int start, int end) {
    int lineCount = buffer.getLineCount();
    if (start > end || start < 0 || end >= lineCount)
        throw new ArrayIndexOutOfBoundsException(start + ", " + end);
    if (start < getFirstVisibleLine() || end > getLastVisibleLine())
        expandAllFolds();
    if (start != 0)
        hideLineRange(0, start - 1);
    if (end != lineCount - 1)
        hideLineRange(end + 1, lineCount - 1);
    // if we narrowed to a single collapsed fold
    if (start != lineCount - 1 && !isLineVisible(start + 1))
        expandFold(start, false);
    textArea.fireNarrowActive();
    notifyScreenLineChanges();
    textArea.foldStructureChanged();
}