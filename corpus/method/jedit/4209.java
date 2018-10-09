//}}}
//{{{ setMenu() method
public void setMenu(JPopupMenu menu) {
    if (menu == null) {
        if (mouseListener != null) {
            removeMouseListener(mouseListener);
            mouseListener = null;
        }
        if (popupMenuListener != null) {
            this.menu.removePopupMenuListener(popupMenuListener);
            popupMenuListener = null;
        }
        parent = null;
    } else {
        parent = new JDialog((Frame) null);
        parent.setUndecorated(true);
        parent.setAlwaysOnTop(true);
        if (mouseListener == null) {
            mouseListener = new MyMouseListener();
            addMouseListener(mouseListener);
        }
        popupMenuListener = new MyPopupMenuListener();
        menu.addPopupMenuListener(popupMenuListener);
    }
    this.menu = menu;
}