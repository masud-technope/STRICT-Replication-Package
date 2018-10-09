//}}}
//{{{ dragOver() method
@Override
public void dragOver(DropTargetDragEvent dtde) {
    if (!dtde.isDataFlavorSupported(DataFlavor.stringFlavor))
        return;
    Point p = dtde.getLocation();
    p = SwingUtilities.convertPoint(textArea, p, textArea.getPainter());
    int pos = textArea.xyToOffset(p.x, p.y, !(textArea.getPainter().isBlockCaretEnabled() || textArea.isOverwriteEnabled()));
    if (pos != -1) {
        textArea.moveCaretPosition(pos, TextArea.ELECTRIC_SCROLL);
    }
}