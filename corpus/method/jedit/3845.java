public void mousePressed(MouseEvent evt) {
    if (popup != null && popup.isVisible()) {
        popup.setVisible(false);
        return;
    }
    Component comp = (Component) evt.getSource();
    String dockable;
    if (comp instanceof JToggleButton)
        dockable = ((JToggleButton) comp).getActionCommand();
    else
        dockable = getCurrent();
    if (comp == menuBtn || GenericGUIUtilities.isPopupTrigger(evt)) {
        if (dockable == null) {
            popup = wm.createPopupMenu(PanelWindowContainer.this, null, false);
        } else {
            popup = wm.createPopupMenu(PanelWindowContainer.this, dockable, false);
        }
        int x, y;
        boolean point;
        if (comp == menuBtn) {
            x = 0;
            y = menuBtn.getHeight();
            point = false;
        } else {
            x = evt.getX();
            y = evt.getY();
            point = true;
        }
        GenericGUIUtilities.showPopupMenu(popup, comp, x, y, point);
    }
}