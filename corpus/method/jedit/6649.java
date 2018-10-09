//}}}
//{{{ subregionOffsetToX() method
/**
	 * Converts an offset within a subregion into an x co-ordinate.
	 * @param info The line info object
	 * @param offset The offset
	 * @return the x co-ordinate of the offset within a subregion
	 */
static int subregionOffsetToX(LineInfo info, int offset) {
    return (int) Chunk.offsetToX(info.chunks, offset);
}