//}}}
//{{{ foldStructureChanged() method
void foldStructureChanged() {
    chunkCache.invalidateAll();
    recalculateLastPhysicalLine();
    if (!displayManager.isLineVisible(caretLine)) {
        int x = chunkCache.subregionOffsetToX(caretLine, caret - getLineStartOffset(caretLine));
        int line = displayManager.getPrevVisibleLine(caretLine);
        if (!multi) {
            // cannot use selectNone() because the finishCaretUpdate method will reopen the fold
            invalidateSelectedLines();
            selectionManager.setSelection((Selection) null);
        }
        moveCaretPosition(buffer.getLineStartOffset(line) + chunkCache.xToSubregionOffset(line, 0, x, true));
    }
    repaint();
}