//{{{ paintSelection() method
private void paintSelection(Graphics2D gfx, int screenLine, int physicalLine, int y, Selection s) {
    int[] selectionStartAndEnd = textArea.selectionManager.getSelectionStartAndEnd(screenLine, physicalLine, s);
    if (selectionStartAndEnd == null)
        return;
    int x1 = selectionStartAndEnd[0];
    int x2 = selectionStartAndEnd[1];
    gfx.fillRect(x1, y, x2 - x1, getLineHeight());
//}}}
}