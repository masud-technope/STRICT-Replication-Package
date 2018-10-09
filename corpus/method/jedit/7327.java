//}}}
//{{{ doTripleClick() method
protected void doTripleClick() {
    int newCaret = textArea.getLineEndOffset(dragStartLine);
    if (dragStartLine == textArea.getLineCount() - 1)
        newCaret--;
    Selection sel = new Selection.Range(textArea.getLineStartOffset(dragStartLine), newCaret);
    if (textArea.isMultipleSelectionEnabled())
        textArea.addToSelection(sel);
    else
        textArea.setSelection(sel);
    if (quickCopyDrag)
        quickCopyDrag = false;
    textArea.moveCaretPosition(newCaret, false);
    dragged = true;
}