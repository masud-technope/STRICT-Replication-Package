@Override
public void mouseClicked(MouseEvent evt) {
    int i = registerList.locationToIndex(evt.getPoint());
    if (i != -1)
        registerList.setSelectedIndex(i);
    if (GenericGUIUtilities.isPopupTrigger(evt)) {
        if (popup == null) {
            popup = new JPopupMenu();
            JMenuItem item = GUIUtilities.loadMenuItem("paste");
            popup.add(item);
            item = new JMenuItem(jEdit.getProperty("clear-string-register.label"));
            item.addActionListener(new ClearHandler());
            popup.add(item);
        }
        GenericGUIUtilities.showPopupMenu(popup, registerList, evt.getX(), evt.getY(), false);
    } else if (evt.getClickCount() % 2 == 0)
        insertRegister();
}