@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    JLabel l = (JLabel) tcr.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    VFSDirectoryEntryTableModel model = (VFSDirectoryEntryTableModel) table.getModel();
    Icon icon = column == model.getSortColumnIndex() ? model.getAscending() ? ASC_ICON : DESC_ICON : null;
    l.setIcon(icon);
    // l.setHorizontalTextPosition(l.LEADING);
    return l;
}