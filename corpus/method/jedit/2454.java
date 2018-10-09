/**
	 * Returns the specified text range in a <code>Segment</code>.<p>
	 *
	 * Using a <classname>Segment</classname> is generally more
	 * efficient than using a <classname>String</classname> because it
	 * results in less memory allocation and array copying.<p>
	 *
	 *
	 * @param start The start offset
	 * @param len The number of characters to get
	 * @param seg The segment to copy the text to
	 * @see JEditBuffer#getText(int, int, Segment)
	 */
public void getText(int start, int len, Segment seg) {
    if (start >= gapStart) {
        seg.array = text;
        seg.offset = start + gapLength();
        seg.count = len;
    } else if (start + len <= gapStart) {
        seg.array = text;
        seg.offset = start;
        seg.count = len;
    } else {
        seg.array = new char[len];
        // copy text before gap
        System.arraycopy(text, start, seg.array, 0, gapStart - start);
        // copy text after gap
        System.arraycopy(text, gapEnd(), seg.array, gapStart - start, len + start - gapStart);
        seg.offset = 0;
        seg.count = len;
    }
}