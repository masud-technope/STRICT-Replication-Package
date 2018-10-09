//}}}
//{{{ recalculateLastPhysicalLine() method
void recalculateLastPhysicalLine() {
    int oldScreenLastLine = screenLastLine;
    for (int i = visibleLines - 1; i >= 0; i--) {
        ChunkCache.LineInfo info = chunkCache.getLineInfo(i);
        if (info.physicalLine > -1) {
            physLastLine = info.physicalLine;
            screenLastLine = i;
            break;
        }
    }
    invalidateScreenLineRange(oldScreenLastLine, screenLastLine);
}