//}}}
//{{{ getLineInfosForPhysicalLine() method
LineInfo[] getLineInfosForPhysicalLine(int physicalLine) {
    if (!buffer.isLoading())
        lineToChunkList(physicalLine);
    assert physicalLine == outFullPhysicalLine;
    List<Chunk> chunkList = null;
    if (outFull.isEmpty()) {
        chunkList = new ArrayList<Chunk>();
        chunkList.add(null);
    } else
        chunkList = outFull;
    List<LineInfo> returnValue = new ArrayList<LineInfo>(chunkList.size());
    getLineInfosForPhysicalLine(physicalLine, returnValue, chunkList);
    return returnValue.toArray(new LineInfo[chunkList.size()]);
}