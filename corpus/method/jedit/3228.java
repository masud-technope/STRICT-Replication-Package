//{{{ mouseMoved() method
public void mouseMoved(MouseEvent evt) {
    Border border = getBorder();
    if (border == null) {
        // collapsed
        return;
    }
    String position = panel.getPosition();
    Insets insets = border.getBorderInsets(DockablePanel.this);
    canDrag = false;
    //{{{ Top...
    if (position.equals(DockableWindowManager.TOP)) {
        if (evt.getY() >= getHeight() - insets.bottom)
            canDrag = true;
    //}}}
    } else //{{{ Left...
    if (position.equals(DockableWindowManager.LEFT)) {
        if (evt.getX() >= getWidth() - insets.right)
            canDrag = true;
    //}}}
    } else //{{{ Bottom...
    if (position.equals(DockableWindowManager.BOTTOM)) {
        if (evt.getY() <= insets.top)
            canDrag = true;
    //}}}
    } else //{{{ Right...
    if (position.equals(DockableWindowManager.RIGHT)) {
        if (evt.getX() <= insets.left)
            canDrag = true;
    //}}}
    }
    if (dragStart == null) {
        if (canDrag) {
            wm.setCursor(Cursor.getPredefinedCursor(getAppropriateCursor()));
        } else {
            wm.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }
//}}}
}