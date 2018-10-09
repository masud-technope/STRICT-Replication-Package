@Override
public void mouseClicked(MouseEvent evt) {
    if (evt.getSource() == table.getTableHeader()) {
        int column = table.getTableHeader().columnAtPoint(evt.getPoint());
        pluginModel.sortDirection *= -1;
        pluginModel.sort(column);
    } else {
        if (GenericGUIUtilities.isPopupTrigger(evt)) {
            int row = table.rowAtPoint(evt.getPoint());
            if (row != -1 && !table.isRowSelected(row)) {
                table.setRowSelectionInterval(row, row);
            }
            if (popup == null) {
                popup = new JPopupMenu();
                JMenuItem item = GUIUtilities.loadMenuItem("plugin-manager.cleanup");
                item.addActionListener(new CleanupActionListener());
                popup.add(item);
            }
            GenericGUIUtilities.showPopupMenu(popup, table, evt.getX(), evt.getY());
        }
    }
}