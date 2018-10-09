//{{{ mouseDragged() method
public void mouseDragged(MouseEvent evt) {
    if (!canDrag)
        return;
    if (// can't happen?
    dragStart == null)
        return;
    int dimension = panel.getDimension();
    String position = panel.getPosition();
    int newSize = 0;
    //{{{ Top...
    if (position.equals(DockableWindowManager.TOP)) {
        newSize = evt.getY();
        wm.setResizePos(evt.getY() - dragStart.y + dimension, panel);
    //}}}
    } else //{{{ Left...
    if (position.equals(DockableWindowManager.LEFT)) {
        newSize = evt.getX();
        wm.setResizePos(evt.getX() - dragStart.x + dimension, panel);
    //}}}
    } else //{{{ Bottom...
    if (position.equals(DockableWindowManager.BOTTOM)) {
        newSize = dimension - evt.getY();
        wm.setResizePos(dimension - evt.getY() + dragStart.y, panel);
    //}}}
    } else //{{{ Right...
    if (position.equals(DockableWindowManager.RIGHT)) {
        newSize = dimension - evt.getX();
        wm.setResizePos(dimension - evt.getX() + dragStart.x, panel);
    //}}}
    }
    if (continuousLayout) {
        panel.setDimension(newSize + PanelWindowContainer.SPLITTER_WIDTH);
        wm.revalidate();
    }
//}}}
}