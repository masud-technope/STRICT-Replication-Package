@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean cellHasFocus, int row, int col) {
    StringBuilder valueStr = new StringBuilder(value.toString());
    // labels starting with <html>, which often breaks
    if (valueStr.toString().toLowerCase().startsWith("<html>"))
        valueStr.insert(' ', 0);
    return super.getTableCellRendererComponent(table, valueStr.toString(), isSelected, cellHasFocus, row, col);
}