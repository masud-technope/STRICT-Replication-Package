//}}}
//{{{ xToOffset() method
/**
	 * Converts an x co-ordinate in a chunk list into an offset.
	 * @param chunks The chunk list
	 * @param x The x co-ordinate
	 * @param round Round up to next letter if past the middle of a letter?
	 * @return The offset within the line, or -1 if the x co-ordinate is too
	 * far to the right
	 * @since jEdit 4.1pre1
	 */
public static int xToOffset(Chunk chunks, float x, boolean round) {
    float _x = 0.0f;
    while (chunks != null) {
        if (chunks.isAccessible() && x < _x + chunks.width)
            return chunks.xToOffset(x - _x, round);
        _x += chunks.width;
        chunks = (Chunk) chunks.next;
    }
    return -1;
}