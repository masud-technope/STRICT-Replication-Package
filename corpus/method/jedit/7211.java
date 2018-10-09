/**
	 * Copies the specified substring of the buffer into a segment.
	 * @param start The start offset
	 * @param len The length of the substring
	 * @param segment The segment
	 */
public final void getText(int start, int len, Segment segment) {
    buffer.getText(start, len, segment);
}