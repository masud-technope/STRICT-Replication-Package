//{{{ Rect constructor
public  Rect(JEditBuffer buffer, int startLine, int startColumn, int endLine, int endColumn) {
    this.startLine = startLine;
    this.endLine = endLine;
    int[] width = new int[1];
    int startOffset = buffer.getOffsetOfVirtualColumn(startLine, startColumn, width);
    if (startOffset == -1) {
        extraStartVirt = startColumn - width[0];
        startOffset = buffer.getLineEndOffset(startLine) - 1;
    } else
        startOffset += buffer.getLineStartOffset(startLine);
    int endOffset = buffer.getOffsetOfVirtualColumn(endLine, endColumn, width);
    if (endOffset == -1) {
        extraEndVirt = endColumn - width[0];
        endOffset = buffer.getLineEndOffset(endLine) - 1;
    } else
        endOffset += buffer.getLineStartOffset(endLine);
    this.start = startOffset;
    this.end = endOffset;
//}}}
}