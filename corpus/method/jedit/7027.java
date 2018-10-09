//}}}
//{{{ offsetToXY() methods
/**
	 * Converts an offset into a point in the text area painter's
	 * co-ordinate space.
	 * @param offset The offset
	 * @return The location of the offset on screen, or <code>null</code>
	 * if the specified offset is not visible
	 */
public Point offsetToXY(int offset) {
    int line = buffer.getLineOfOffset(offset);
    offset -= buffer.getLineStartOffset(line);
    Point retVal = new Point();
    return offsetToXY(line, offset, retVal);
}