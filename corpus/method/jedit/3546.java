@Override
public void mousePressed(MouseEvent evt) {
    if (popup != null && popup.isVisible())
        popup.setVisible(false);
    else {
        popup = dockableWindowManager.createPopupMenu(FloatingWindowContainer.this, entry.factory.name, clone);
        GenericGUIUtilities.showPopupMenu(popup, menu, menu.getX(), menu.getY() + menu.getHeight(), false);
    }
}