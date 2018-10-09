//}}}
//{{{ tallCaretDelete() method
private void tallCaretDelete(Selection.Rect s, boolean forward) {
    try {
        buffer.beginCompoundEdit();
        int[] width = new int[1];
        int startCol = s.getStartColumn(buffer);
        int startLine = s.startLine;
        int endLine = s.endLine;
        for (int i = startLine; i <= endLine; i++) {
            int offset = buffer.getOffsetOfVirtualColumn(i, startCol, width);
            if (offset == -1) {
                if (width[0] == startCol)
                    offset = getLineLength(i);
                else {
                    if (i == startLine && !forward)
                        shiftTallCaretLeft(s);
                    continue;
                }
            }
            offset += buffer.getLineStartOffset(i);
            if (forward) {
                if (offset != buffer.getLineEndOffset(i) - 1)
                    deleteNextCharacter(offset);
            } else
                deletePrevCodePoint(offset);
        }
    } finally {
        buffer.endCompoundEdit();
    }
}