/**
	 * Returns the specified line in a <code>Segment</code>.<p>
	 *
	 * Using a <code>Segment</code> is generally more
	 * efficient than using a <code>String</code> because it
	 * results in less memory allocation and array copying.<p>
	 *
	 * This method is thread-safe.
	 *
	 * @param line The line
	 * @param segment the segment
	 * @since jEdit 4.0pre1
	 */
public void getLineText(int line, Segment segment) {
    getLineText(line, 0, segment);
}