@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    if (column == 5)
        tcr.setHorizontalAlignment(TRAILING);
    else
        tcr.setHorizontalAlignment(LEADING);
    return tcr.getTableCellRendererComponent(table, value, isSelected, false, row, column);
}