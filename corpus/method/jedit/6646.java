//}}}
//{{{ getLineSubregionCount() method
/**
	 * Returns the number of subregions of a physical line
	 * @param physicalLine a physical line
	 * @return the number of subregions of this physical line
	 */
int getLineSubregionCount(int physicalLine) {
    if (!textArea.softWrap)
        return 1;
    lineToChunkList(physicalLine);
    int size = outFull.size();
    if (size == 0)
        return 1;
    else
        return size;
}