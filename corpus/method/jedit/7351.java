//{{{ paintValidLine() method
@Override
public void paintValidLine(Graphics2D gfx, int screenLine, int physicalLine, int start, int end, int y) {
    if (textArea.getSelectionCount() == 0)
        return;
    if ((!isSelectionFgColorEnabled()) || (getSelectionFgColor() == null))
        return;
    Iterator<Selection> iter = textArea.getSelectionIterator();
    while (iter.hasNext()) {
        Selection s = iter.next();
        paintSelection(gfx, screenLine, physicalLine, y, s);
    }
//}}}
}