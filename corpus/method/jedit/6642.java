//}}}
//{{{ getSubregionStartOffset() method
/**
	 * Returns the start offset of the specified subregion of the specified
	 * physical line.
	 * @param line The physical line number
	 * @param offset An offset
	 * @return the start offset of the subregion of the line
	 */
int getSubregionStartOffset(int line, int offset) {
    LineInfo[] lineInfos = getLineInfosForPhysicalLine(line);
    LineInfo info = lineInfos[getSubregionOfOffset(offset, lineInfos)];
    return textArea.getLineStartOffset(info.physicalLine) + info.offset;
}