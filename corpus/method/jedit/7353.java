//{{{ paintValidLine() method
@Override
public void paintValidLine(Graphics2D gfx, int screenLine, int physicalLine, int start, int end, int y) {
    if (textArea.getSelectionCount() == 0)
        return;
    gfx.setColor(textArea.isMultipleSelectionEnabled() ? getMultipleSelectionColor() : getSelectionColor());
    Iterator<Selection> iter = textArea.getSelectionIterator();
    while (iter.hasNext()) {
        Selection s = iter.next();
        paintSelection(gfx, screenLine, physicalLine, y, s);
    }
//}}}
}