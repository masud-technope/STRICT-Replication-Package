//{{{ mouseReleased() method
public void mouseReleased(MouseEvent evt) {
    if (canDrag) {
        if (!continuousLayout) {
            panel.setDimension(wm.resizePos + PanelWindowContainer.SPLITTER_WIDTH);
        }
        wm.finishResizing();
        dragStart = null;
        wm.revalidate();
    }
//}}}
}