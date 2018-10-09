/**
	 * Converts a point to an offset.
	 * Note that unlike in previous jEdit versions, this method now returns
	 * -1 if the y co-ordinate is out of bounds.
	 *
	 * @param x The x co-ordinate of the point
	 * @param y The y co-ordinate of the point
	 * @param round Round up to next character if past the middle of a character?
	 * @since jEdit 3.2pre6
	 */
public int xyToOffset(int x, int y, boolean round) {
    int height = painter.getLineHeight();
    int line = y / height;
    if (line < 0 || line >= visibleLines)
        return -1;
    return xToScreenLineOffset(line, x, round);
}