//}}}
//{{{ doTripleDrag() method
private void doTripleDrag(MouseEvent evt) {
    TextAreaPainter painter = textArea.getPainter();
    int offset = textArea.xyToOffset(evt.getX(), Math.max(0, Math.min(painter.getHeight(), evt.getY())), false);
    int mouseLine = textArea.getLineOfOffset(offset);
    int mark;
    int mouse;
    if (dragStartLine > mouseLine) {
        mark = textArea.getLineEndOffset(dragStartLine) - 1;
        if (offset == textArea.getLineEndOffset(mouseLine) - 1)
            mouse = offset;
        else
            mouse = textArea.getLineStartOffset(mouseLine);
    } else {
        mark = textArea.getLineStartOffset(dragStartLine);
        if (offset == textArea.getLineStartOffset(mouseLine))
            mouse = offset;
        else if (offset == textArea.getLineEndOffset(mouseLine) - 1 && mouseLine != textArea.getLineCount() - 1)
            mouse = textArea.getLineEndOffset(mouseLine);
        else
            mouse = textArea.getLineEndOffset(mouseLine) - 1;
    }
    mouse = Math.min(textArea.getBuffer().getLength(), mouse);
    if (mouse == textArea.getCaretPosition())
        return;
    textArea.resizeSelection(mark, mouse, 0, false);
    textArea.moveCaretPosition(mouse, false);
    dragged = true;
}