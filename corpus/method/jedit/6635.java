//}}}
//{{{ getLineInfosForPhysicalLine() method
private void getLineInfosForPhysicalLine(int physicalLine, List<LineInfo> list, List<Chunk> chunkList) {
    assert outFullPhysicalLine == physicalLine;
    for (int i = 0; i < chunkList.size(); i++) {
        Chunk chunks = chunkList.get(i);
        LineInfo info = new LineInfo();
        info.physicalLine = physicalLine;
        if (i == 0) {
            info.firstSubregion = true;
            info.offset = 0;
        } else
            info.offset = chunks.offset;
        if (i == chunkList.size() - 1) {
            info.lastSubregion = true;
            info.length = textArea.getLineLength(physicalLine) - info.offset + 1;
        } else {
            info.length = outFull.get(i + 1).offset - info.offset;
        }
        info.chunks = chunks;
        list.add(info);
    }
}