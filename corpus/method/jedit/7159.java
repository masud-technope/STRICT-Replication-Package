//}}}
//{{{ shiftTallCaretLeft() method
private void shiftTallCaretLeft(Selection.Rect s) {
    removeFromSelection(s);
    addToSelection(new Selection.Rect(buffer, s.getStartLine(), s.getStartColumn(buffer) - 1, s.getEndLine(), s.getEndColumn(buffer) - 1));
}