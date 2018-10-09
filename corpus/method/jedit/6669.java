//}}}
//{{{ getContainingBlock() method
public ColumnBlock getColumnBlock(int line, int offset) {
    if (isDirty) {
        return null;
    }
    // int tabSize=-5;
    synchronized (buffer.columnBlockLock) {
        ColumnBlock colBlock = null;
        if (line >= startLine && line <= endLine) {
            if (lines != null && !lines.isEmpty()) {
                ColumnBlockLine blockLine = lines.get(line - startLine);
                if (blockLine.getColumnEndIndex() + buffer.getLineStartOffset(line) == offset) {
                    // tabSize =
                    // blockLine.getTabSize();
                    colBlock = this;
                }
            }
            if (colBlock == null && children != null && !children.isEmpty()) {
                ColumnBlock block = searchChildren(line, 0, children.size() - 1);
                if (block == null || block.isLineWithinThisBlock(line) != 0) {
                    throwException(offset, line);
                }
                // tabSize =
                // block.getColumnBlock(line,offset);
                colBlock = block.getColumnBlock(line, offset);
            }
        }
        // if(tabSize<0)
        if (colBlock == null)
            throwException(offset, line);
        // return tabSize;
        return colBlock;
    }
}