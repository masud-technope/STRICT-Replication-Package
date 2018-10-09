public void updateColumnBlocks(int startLine, int endLine, int startColumn, Node parent) {
    if (parent != null && startLine >= 0 && endLine >= 0 && startLine <= endLine) {
        int currentLine = startLine;
        int colBlockWidth = 0;
        Vector<ColumnBlockLine> columnBlockLines = new Vector<ColumnBlockLine>();
        ColumnBlock parentColumnBlock = (ColumnBlock) parent;
        for (int ik = startLine - parentColumnBlock.getStartLine(); currentLine <= endLine; ik++) {
            Segment seg = new Segment();
            int actualStart = startColumn;
            if (!parentColumnBlock.getLines().isEmpty()) {
                ColumnBlockLine line = parentColumnBlock.getLines().elementAt(ik);
                if (currentLine != line.getLine()) {
                    throw new IllegalArgumentException();
                }
                actualStart = line.getColumnEndIndex() + 1;
            }
            getLineText(currentLine, actualStart, seg);
            int tabPos = getTabStopPosition(seg);
            if (tabPos >= 0) {
                columnBlockLines.add(new ColumnBlockLine(currentLine, actualStart, actualStart + tabPos));
                if (tabPos > colBlockWidth) {
                    colBlockWidth = tabPos;
                }
            }
            if (tabPos < 0 && !columnBlockLines.isEmpty() || !columnBlockLines.isEmpty() && currentLine == endLine) {
                ColumnBlock block = new ColumnBlock(this, columnBlockLines.elementAt(0).getLine(), startColumn + colBlockWidth, columnBlockLines.elementAt(columnBlockLines.size() - 1).getLine(), startColumn + colBlockWidth);
                block.setLines(columnBlockLines);
                block.setParent(parent);
                block.setWidth(colBlockWidth);
                block.setTabSizeDirtyStatus(true, false);
                parent.addChild(block);
                colBlockWidth = 0;
                columnBlockLines = new Vector<ColumnBlockLine>();
                updateColumnBlocks(block.getStartLine(), block.getEndLine(), startColumn + block.getColumnWidth() + 1, block);
            }
            currentLine++;
        }
    } else {
        throw new IllegalArgumentException();
    }
}