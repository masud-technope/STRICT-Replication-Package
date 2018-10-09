//}}}
//{{{ getContainingBlock() method
public ColumnBlock getContainingBlock(int line, int offset) {
    ColumnBlock retBlock = null;
    if (line >= startLine && line <= endLine) {
        int relativeOffset = offset - buffer.getLineStartOffset(line);
        if (lines != null && !lines.isEmpty()) {
            ColumnBlockLine blockLine = lines.get(line - startLine);
            if (blockLine.getColumnEndIndex() >= relativeOffset && blockLine.getColumnStartIndex() <= relativeOffset) {
                retBlock = this;
            }
        }
        if (retBlock == null && children != null && !children.isEmpty()) {
            ColumnBlock block = searchChildren(line);
            if (block != null && block.isLineWithinThisBlock(line) == 0) {
                retBlock = block.getContainingBlock(line, offset);
            }
        }
    }
    return retBlock;
}