/**
	 * Copies the text on the specified line into a Segment. If lineIndex
	 * is invalid, the segment will contain a null string.
	 * @param lineIndex The line number (physical line)
	 * @param segment the segment into which the data will be stored.
	 */
public final void getLineText(int lineIndex, Segment segment) {
    buffer.getLineText(lineIndex, segment);
}