//{{{ contentInserted() method
@Override
boolean contentInserted(JEditBuffer buffer, int startLine, int start, int numLines, int length) {
    if (this.end < start)
        return false;
    this.end += length;
    if (this.startLine > startLine) {
        this.start += length;
        if (numLines != 0) {
            this.startLine = buffer.getLineOfOffset(this.start);
            this.endLine = buffer.getLineOfOffset(this.end);
        }
        return true;
    }
    int endVirtualColumn = buffer.getVirtualWidth(this.endLine, end - buffer.getLineStartOffset(this.endLine));
    if (this.start == start) {
        int startVirtualColumn = buffer.getVirtualWidth(this.startLine, start - buffer.getLineStartOffset(this.startLine));
        this.start += length;
        int newStartVirtualColumn = buffer.getVirtualWidth(startLine, start - buffer.getLineStartOffset(this.startLine));
        int[] totalVirtualWidth = new int[1];
        int newEnd = buffer.getOffsetOfVirtualColumn(this.endLine, endVirtualColumn + newStartVirtualColumn - startVirtualColumn, totalVirtualWidth);
        if (newEnd != -1) {
            end = buffer.getLineStartOffset(this.endLine) + newEnd;
        } else {
            end = buffer.getLineEndOffset(this.endLine) - 1;
            extraEndVirt = totalVirtualWidth[0] - endVirtualColumn;
        }
    } else if (this.start > start) {
        this.start += length;
        if (numLines != 0) {
            this.startLine = buffer.getLineOfOffset(this.start);
        }
    }
    if (numLines != 0)
        this.endLine = buffer.getLineOfOffset(this.end);
    int newEndVirtualColumn = buffer.getVirtualWidth(endLine, end - buffer.getLineStartOffset(this.endLine));
    if (startLine == this.endLine && extraEndVirt != 0) {
        extraEndVirt += endVirtualColumn - newEndVirtualColumn;
    } else if (startLine == this.startLine && extraStartVirt != 0) {
        extraStartVirt += endVirtualColumn - newEndVirtualColumn;
    }
    return true;
//}}}
}