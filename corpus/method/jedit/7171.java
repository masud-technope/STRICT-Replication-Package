//}}}
//{{{ joinLine() method
/**
	 * Join a line with the next line.
	 * If you use this method you have to lock the buffer in compound edit mode.
	 * @param line the line number that will be joined with the next line
	 */
private void joinLineAt(int line) {
    if (line >= buffer.getLineCount() - 1)
        return;
    int end = getLineEndOffset(line);
    CharSequence nextLineText = buffer.getLineSegment(line + 1);
    buffer.remove(end - 1, StandardUtilities.getLeadingWhiteSpace(nextLineText) + 1);
    if (nextLineText.length() != 0)
        buffer.insert(end - 1, " ");
}