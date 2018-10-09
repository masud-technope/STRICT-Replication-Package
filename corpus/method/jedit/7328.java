//}}}
//{{{ doDoubleClick() method
protected void doDoubleClick() {
    // Ignore empty lines
    if (textArea.getLineLength(dragStartLine) == 0)
        return;
    String lineText = textArea.getLineText(dragStartLine);
    String noWordSep = textArea.getBuffer().getStringProperty("noWordSep");
    if (dragStartOffset == textArea.getLineLength(dragStartLine))
        dragStartOffset--;
    boolean joinNonWordChars = textArea.getJoinNonWordChars();
    int wordStart = TextUtilities.findWordStart(lineText, dragStartOffset, noWordSep, joinNonWordChars, false, false);
    int wordEnd = TextUtilities.findWordEnd(lineText, dragStartOffset + 1, noWordSep, joinNonWordChars, false, false);
    int lineStart = textArea.getLineStartOffset(dragStartLine);
    Selection sel = new Selection.Range(lineStart + wordStart, lineStart + wordEnd);
    if (textArea.isMultipleSelectionEnabled())
        textArea.addToSelection(sel);
    else
        textArea.setSelection(sel);
    if (quickCopyDrag)
        quickCopyDrag = false;
    textArea.moveCaretPosition(lineStart + wordEnd, false);
    dragged = true;
}