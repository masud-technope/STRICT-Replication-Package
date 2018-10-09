//}}}
//{{{ offsetToX() method
/**
	 * Converts an offset in a chunk list into an x co-ordinate.
	 * @param chunks The chunk list
	 * @param offset The offset
	 * @since jEdit 4.1pre1
	 */
public static float offsetToX(Chunk chunks, int offset) {
    if (chunks != null && offset < chunks.offset) {
        throw new ArrayIndexOutOfBoundsException(offset + " < " + chunks.offset);
    }
    float x = 0.0f;
    while (chunks != null) {
        if (chunks.isAccessible() && offset < chunks.offset + chunks.length)
            return x + chunks.offsetToX(offset - chunks.offset);
        x += chunks.width;
        chunks = (Chunk) chunks.next;
    }
    return x;
}