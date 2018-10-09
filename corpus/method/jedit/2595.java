/**
	 * Inserts a string into the buffer.
	 * @param offset The offset
	 * @param seg The segment
	 * @since jEdit 4.0pre1
	 */
public void insert(int offset, Segment seg) {
    insert(offset, (CharSequence) seg);
}