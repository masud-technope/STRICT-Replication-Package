@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    Entry entry = pluginModel.getEntry(row);
    if (entry.status.equals(Entry.ERROR) || entry.status.equals(Entry.DISABLED))
        tcr.setForeground(Color.red);
    else
        tcr.setForeground(UIManager.getColor("Table.foreground"));
    return tcr.getTableCellRendererComponent(table, value, isSelected, false, row, column);
}