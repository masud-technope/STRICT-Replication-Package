@Override
public void mouseClicked(MouseEvent e) {
    if (Log.throwables.isEmpty())
        return;
    if (GenericGUIUtilities.isRightButton(e.getModifiersEx())) {
        JPopupMenu menu = GUIUtilities.loadPopupMenu("errorwidget.popupmenu");
        GenericGUIUtilities.showPopupMenu(menu, ErrorHighlight.this, e.getX(), e.getY());
    } else if (e.getClickCount() == 2)
        new ErrorDialog(view);
}