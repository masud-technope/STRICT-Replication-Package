//}}}
//{{{ xToSubregionOffset() method
/**
	 * Converts an x co-ordinate within a subregion into an offset from the
	 * start of that subregion.
	 * @param physicalLine The physical line number
	 * @param subregion The subregion; if -1, then this is the last
	 * subregion.
	 * @param x The x co-ordinate
	 * @param round Round up to next character if x is past the middle of a
	 * character?
	 * @return the offset from the start of the subregion
	 */
int xToSubregionOffset(int physicalLine, int subregion, int x, boolean round) {
    LineInfo[] infos = getLineInfosForPhysicalLine(physicalLine);
    if (subregion == -1)
        subregion += infos.length;
    return xToSubregionOffset(infos[subregion], x, round);
}