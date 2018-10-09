/**
	 * Converts an offset into a point in the text area painter's
	 * co-ordinate space.
	 * @param line The line
	 * @param offset The offset
	 * @return The location of the offset on screen, or <code>null</code>
	 * if the specified offset is not visible
	 */
public Point offsetToXY(int line, int offset) {
    return offsetToXY(line, offset, new Point());
}