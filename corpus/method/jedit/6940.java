//{{{ getEndColumn() method
public int getEndColumn(JEditBuffer buffer) {
    int virtColStart = buffer.getVirtualWidth(startLine, start - buffer.getLineStartOffset(startLine)) + extraStartVirt;
    int virtColEnd = buffer.getVirtualWidth(endLine, end - buffer.getLineStartOffset(endLine)) + extraEndVirt;
    return Math.max(virtColStart, virtColEnd);
//}}}
}