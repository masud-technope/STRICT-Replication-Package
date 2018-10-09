@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    JLabel l = (JLabel) tcr.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    PluginTableModel model = (PluginTableModel) table.getModel();
    Icon icon = (column == model.sortType) ? (model.sortDirection == 1) ? InstallPanel.ASC_ICON : InstallPanel.DESC_ICON : null;
    l.setIcon(icon);
    return l;
}