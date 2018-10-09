//}}}
//{{{ getTabSize() method
private float getTabSize(ColumnBlock columnBlock, int line) {
    float ret = -5;
    if (columnBlock != null) {
        Vector<ColumnBlockLine> lines = columnBlock.getLines();
        if (columnBlock.areTabSizesDirty()) {
            float colBlockWidth = -1;
            for (int i = 0; i < lines.size(); i++) {
                ColumnBlockLine colBlockLine = (ColumnBlockLine) lines.elementAt(i);
                int startOffset = colBlockLine.getColumnStartIndex() + textArea.buffer.getLineStartOffset(colBlockLine.getLine());
                String str = textArea.buffer.getText(startOffset, colBlockLine.getColumnEndIndex() - colBlockLine.getColumnStartIndex());
                float width = 0;
                if (str.length() != 0) {
                    TextLayout layout = new TextLayout(str, textArea.painter.getFont(), textArea.painter.getFontRenderContext());
                    width = layout.getAdvance();
                }
                colBlockLine.lineLength = width;
                //colBlockLine.lineLength = textArea.painter.getFontMetrics().stringWidth(str);
                if ((colBlockWidth < 0) || (colBlockLine.lineLength > colBlockWidth)) {
                    colBlockWidth = colBlockLine.lineLength;
                }
            }
            columnBlock.columnBlockWidth = colBlockWidth;
            columnBlock.setTabSizeDirtyStatus(false, false);
        }
        ret = columnBlock.columnBlockWidth - ((ColumnBlockLine) lines.get(line - columnBlock.startLine)).lineLength;
    }
    return ret;
}