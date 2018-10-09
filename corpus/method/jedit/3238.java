//{{{ getCursor() method
private int getAppropriateCursor() {
    String position = panel.getPosition();
    if (position.equals(DockableWindowManager.TOP))
        return Cursor.N_RESIZE_CURSOR;
    else if (position.equals(DockableWindowManager.LEFT))
        return Cursor.W_RESIZE_CURSOR;
    else if (position.equals(DockableWindowManager.BOTTOM))
        return Cursor.S_RESIZE_CURSOR;
    else if (position.equals(DockableWindowManager.RIGHT))
        return Cursor.E_RESIZE_CURSOR;
    else
        throw new InternalError();
//}}}
}