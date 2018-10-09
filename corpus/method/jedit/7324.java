//}}}
//{{{ doSingleDrag() method
private void doSingleDrag(MouseEvent evt) {
    dragged = true;
    TextAreaPainter painter = textArea.getPainter();
    int x = evt.getX();
    int y = evt.getY();
    if (y < 0)
        y = 0;
    else if (y >= painter.getHeight())
        y = painter.getHeight() - 1;
    int dot = textArea.xyToOffset(x, y, (!painter.isBlockCaretEnabled() && !textArea.isOverwriteEnabled()) || quickCopyDrag);
    int dotLine = textArea.getLineOfOffset(dot);
    int extraEndVirt = 0;
    if (textArea.chunkCache.getLineInfo(textArea.getLastScreenLine()).lastSubregion) {
        int screenLine = textArea.getScreenLineOfOffset(dot);
        ChunkCache.LineInfo lineInfo = textArea.chunkCache.getLineInfo(screenLine);
        int offset = textArea.getScreenLineEndOffset(screenLine);
        if ((1 != offset - dot) || (lineInfo.lastSubregion)) {
            offset--;
        }
        float dotLineWidth = textArea.offsetToXY(offset).x;
        if (x > dotLineWidth) {
            extraEndVirt = (int) ((x - dotLineWidth) / textArea.charWidth);
            if (!painter.isBlockCaretEnabled() && !textArea.isOverwriteEnabled() && (x - textArea.getHorizontalOffset()) % textArea.charWidth > textArea.charWidth / 2)
                extraEndVirt++;
        }
    }
    textArea.resizeSelection(dragStart, dot, extraEndVirt, textArea.isRectangularSelectionEnabled() || (control && ctrlForRectangularSelection));
    if (quickCopyDrag) {
        // just scroll to the dragged location
        textArea.scrollTo(dotLine, dot - textArea.getLineStartOffset(dotLine), false);
    } else {
        Point p = textArea.offsetToXY(dot);
        if (dot != textArea.getCaretPosition()) {
            // defer scroll to mouserelease if result is offscreen left without dragging that direction
            textArea.moveCaretPosition(dot, (p.x < 0 && x > 1) ? TextArea.NO_SCROLL : TextArea.NORMAL_SCROLL);
        } else if (p.x < 0 && x < 1) {
            // caret already offscreen left, user now attempting to drag left
            textArea.scrollToCaret(false);
        }
        if (textArea.isRectangularSelectionEnabled() && extraEndVirt != 0) {
            textArea.scrollTo(dotLine, dot - textArea.getLineStartOffset(dotLine) + extraEndVirt, false);
        }
    }
}