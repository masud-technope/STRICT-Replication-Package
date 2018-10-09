//}}}
//{{{ doSingleClick() method
protected void doSingleClick(MouseEvent evt) {
    int x = evt.getX();
    int extraEndVirt = 0;
    if (textArea.chunkCache.getLineInfo(textArea.getLastScreenLine()).lastSubregion) {
        int dragStart = textArea.xyToOffset(x, evt.getY(), !textArea.getPainter().isBlockCaretEnabled() && !textArea.isOverwriteEnabled());
        int screenLine = textArea.getScreenLineOfOffset(dragStart);
        ChunkCache.LineInfo lineInfo = textArea.chunkCache.getLineInfo(screenLine);
        int offset = textArea.getScreenLineEndOffset(screenLine);
        if ((1 != offset - dragStart) || (lineInfo.lastSubregion)) {
            offset--;
        }
        float dragStartLineWidth = textArea.offsetToXY(offset).x;
        if (x > dragStartLineWidth) {
            extraEndVirt = (int) ((x - dragStartLineWidth) / textArea.charWidth);
            if (!textArea.getPainter().isBlockCaretEnabled() && !textArea.isOverwriteEnabled() && (x - textArea.getHorizontalOffset()) % textArea.charWidth > textArea.charWidth / 2) {
                extraEndVirt++;
            }
        }
    }
    if (((control && ctrlForRectangularSelection) || textArea.isRectangularSelectionEnabled()) && textArea.isEditable()) {
        int screenLine = (evt.getY() / textArea.getPainter().getLineHeight());
        if (screenLine > textArea.getLastScreenLine())
            screenLine = textArea.getLastScreenLine();
        ChunkCache.LineInfo info = textArea.chunkCache.getLineInfo(screenLine);
        if (info.lastSubregion && extraEndVirt != 0) {
            // control-click in virtual space inserts
            // whitespace and moves caret
            String whitespace = StandardUtilities.createWhiteSpace(extraEndVirt, 0);
            textArea.getBuffer().insert(dragStart, whitespace);
            dragStart += whitespace.length();
        }
    }
    if (evt.isShiftDown()) {
        textArea.resizeSelection(getSelectionPivotCaret(), dragStart, extraEndVirt, textArea.isRectangularSelectionEnabled() || (control && ctrlForRectangularSelection));
        if (!quickCopyDrag)
            textArea.moveCaretPosition(dragStart, false);
        // so that shift-click-drag works
        dragStartLine = getSelectionPivotLine();
        dragStart = getSelectionPivotCaret();
        dragStartOffset = dragStart - textArea.getLineStartOffset(dragStartLine);
        // so that quick copy works
        dragged = true;
        return;
    }
    if (!quickCopyDrag) {
        Point p = textArea.offsetToXY(dragStart);
        // defer scrolling until mouserelease if result is off-screen
        textArea.moveCaretPosition(dragStart, (p.x < 0) ? TextArea.NO_SCROLL : TextArea.NORMAL_SCROLL);
    }
    if (!(textArea.isMultipleSelectionEnabled() || quickCopyDrag))
        textArea.selectNone();
}