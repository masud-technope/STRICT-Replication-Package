@Override
public void mouseClicked(MouseEvent e) {
    if (GenericGUIUtilities.isPopupTrigger(e)) {
        parent.setLocation(e.getX(), e.getY() - menu.getPreferredSize().height);
        parent.setVisible(true);
        menu.show(parent, 0, 0);
    }
}