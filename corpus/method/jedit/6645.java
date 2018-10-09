//}}}
//{{{ getSubregionOfOffset() method
/**
	 * Returns the subregion containing the specified offset. A subregion
	 * is a subset of a physical line. Each screen line corresponds to one
	 * subregion. Unlike the {@link #getScreenLineOfOffset(int, int)} method,
	 * this method works with non-visible lines too.
	 *
	 * @param offset the offset
	 * @param lineInfos a lineInfos array. Usualy the array is the result of
	 *	{@link #getLineInfosForPhysicalLine(int)} call
	 *
	 * @return the subregion of the offset, or -1 if the offset was not in one of the given lineInfos
	 */
static int getSubregionOfOffset(int offset, LineInfo[] lineInfos) {
    for (int i = 0; i < lineInfos.length; i++) {
        LineInfo info = lineInfos[i];
        if (offset >= info.offset && offset < info.offset + info.length)
            return i;
    }
    return -1;
}