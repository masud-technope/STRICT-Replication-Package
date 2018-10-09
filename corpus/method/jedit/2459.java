/**
	 * Inserts the given data into the buffer.
	 *
	 * @since jEdit 4.3pre15
	 */
public void insert(int start, CharSequence str) {
    int len = str.length();
    prepareGapForInsertion(start, len);
    for (int i = 0; i < len; i++) {
        text[start + i] = str.charAt(i);
    }
    gapStart += len;
    length += len;
}