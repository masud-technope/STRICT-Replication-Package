//}}}
//{{{ userInputTab() method
protected void userInputTab() {
    if (getSelectionCount() == 1) {
        Selection sel = getSelection(0);
        if (sel instanceof Selection.Rect || (sel.startLine == sel.endLine && (sel.start != buffer.getLineStartOffset(sel.startLine) || sel.end != buffer.getLineEndOffset(sel.startLine) - 1))) {
            insertTab();
        } else
            shiftIndentRight();
    } else if (getSelectionCount() != 0)
        shiftIndentRight();
    else
        insertTab();
}