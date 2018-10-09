//}}}
//{{{ doDoubleDrag() method
private void doDoubleDrag(MouseEvent evt) {
    int markLineStart = textArea.getLineStartOffset(dragStartLine);
    int markLineLength = textArea.getLineLength(dragStartLine);
    int mark = dragStartOffset;
    TextAreaPainter painter = textArea.getPainter();
    int pos = textArea.xyToOffset(evt.getX(), Math.max(0, Math.min(painter.getHeight(), evt.getY())), !(painter.isBlockCaretEnabled() || textArea.isOverwriteEnabled()));
    int line = textArea.getLineOfOffset(pos);
    int lineStart = textArea.getLineStartOffset(line);
    int lineLength = textArea.getLineLength(line);
    int offset = pos - lineStart;
    String lineText = textArea.getLineText(line);
    String markLineText = textArea.getLineText(dragStartLine);
    String noWordSep = textArea.getBuffer().getStringProperty("noWordSep");
    boolean joinNonWordChars = textArea.getJoinNonWordChars();
    if (markLineStart + dragStartOffset > lineStart + offset) {
        if (offset != 0 && offset != lineLength) {
            offset = TextUtilities.findWordStart(lineText, offset, noWordSep, joinNonWordChars);
        }
        if (markLineLength != 0) {
            mark = TextUtilities.findWordEnd(markLineText, mark, noWordSep, joinNonWordChars);
        }
    } else {
        if (offset != 0 && lineLength != 0) {
            offset = TextUtilities.findWordEnd(lineText, offset, noWordSep, joinNonWordChars);
        }
        if (mark != 0 && mark != markLineLength) {
            mark = TextUtilities.findWordStart(markLineText, mark, noWordSep, joinNonWordChars);
        }
    }
    if (lineStart + offset == textArea.getCaretPosition())
        return;
    textArea.resizeSelection(markLineStart + mark, lineStart + offset, 0, false);
    textArea.moveCaretPosition(lineStart + offset, false);
    dragged = true;
}