//{{{ invalidateChunksFromPhys() method
void invalidateChunksFromPhys(int physicalLine) {
    if (physicalLine == outFullPhysicalLine)
        outFullPhysicalLine = -1;
    for (int i = 0; i < firstInvalidLine; i++) {
        LineInfo info = lineInfo[i];
        if (info.physicalLine == -1 || info.physicalLine >= physicalLine) {
            firstInvalidLine = i;
            if (i <= lastScreenLine)
                lastScreenLine = lastScreenLineP = -1;
            break;
        }
    }
}