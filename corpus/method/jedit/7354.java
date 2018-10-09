//{{{ shouldPaintLineHighlight() method
private boolean shouldPaintLineHighlight(int caret, int start, int end) {
    if (!isLineHighlightEnabled() || caret < start || caret >= end) {
        return false;
    }
    int count = textArea.getSelectionCount();
    if (count == 1) {
        Selection s = textArea.getSelection(0);
        return s.getStartLine() == s.getEndLine();
    } else
        return count == 0;
//}}}
}