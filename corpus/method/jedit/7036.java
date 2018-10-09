//}}}
//}}}
//{{{ Offset conversion
//{{{ xyToOffset() methods
/**
	 * Converts a point to an offset.
	 * Note that unlike in previous jEdit versions, this method now returns
	 * -1 if the y co-ordinate is out of bounds.
	 *
	 * @param x The x co-ordinate of the point
	 * @param y The y co-ordinate of the point
	 */
public int xyToOffset(int x, int y) {
    return xyToOffset(x, y, true);
}