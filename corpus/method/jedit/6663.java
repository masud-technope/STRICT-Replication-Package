//}}}
//{{{ updateColumnBlockLineOffset() method
public void updateColumnBlockLineOffset(int line, int offsetAdd, boolean increaseStartOffset) {
    if (line >= startLine && line <= endLine) {
        if (lines != null && !lines.isEmpty()) {
            ColumnBlockLine blockLine = lines.get(line - startLine);
            if (increaseStartOffset) {
                blockLine.colStartIndex += offsetAdd;
            }
            blockLine.colEndIndex += offsetAdd;
        }
        if (children != null && !children.isEmpty()) {
            ColumnBlock block = searchChildren(line);
            if (block != null && block.isLineWithinThisBlock(line) == 0) {
                block.updateColumnBlockLineOffset(line, offsetAdd, true);
            }
        }
    }
}