//}}}
//{{{ subregionOffsetToX() method
/**
	 * Converts an offset within a subregion into an x co-ordinate.
	 * @param physicalLine The physical line
	 * @param offset The offset
	 * @return the x co-ordinate of the offset within a subregion
	 */
int subregionOffsetToX(int physicalLine, int offset) {
    LineInfo[] infos = getLineInfosForPhysicalLine(physicalLine);
    LineInfo info = infos[getSubregionOfOffset(offset, infos)];
    return subregionOffsetToX(info, offset);
}