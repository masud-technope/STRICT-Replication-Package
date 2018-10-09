//}}}
//{{{ getSegment() method
/**
	 * Returns a read-only segment of the buffer.
	 * It doesn't copy the text
	 *
	 * @param start The start offset
	 * @param len The number of characters to get
	 *
	 * @return a CharSequence that contains the text wanted text
	 * @since jEdit 4.3pre15
	 */
public CharSequence getSegment(int start, int len) {
    if (start >= gapStart)
        return new BufferSegment(text, start + gapLength(), len);
    else if (start + len <= gapStart)
        return new BufferSegment(text, start, len);
    else {
        return new BufferSegment(text, start, gapStart - start, new BufferSegment(text, gapEnd(), start + len - gapStart));
    }
}