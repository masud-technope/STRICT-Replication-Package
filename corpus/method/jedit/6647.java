//}}}
//{{{ xToSubregionOffset() method
/**
	 * Converts an x co-ordinate within a subregion into an offset from the
	 * start of that subregion.
	 * @param info The line info object
	 * @param x The x co-ordinate
	 * @param round Round up to next character if x is past the middle of a
	 * character?
	 * @return the offset from the start of the subregion
	 */
static int xToSubregionOffset(LineInfo info, int x, boolean round) {
    int offset = Chunk.xToOffset(info.chunks, x, round);
    if (offset == -1 || offset == info.offset + info.length)
        offset = info.offset + info.length - 1;
    return offset;
}