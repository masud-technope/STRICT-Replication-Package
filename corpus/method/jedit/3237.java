//{{{ mouseExited() method
public void mouseExited(MouseEvent evt) {
    if (dragStart == null) {
        wm.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
//}}}
}