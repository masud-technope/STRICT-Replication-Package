@Override
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    Entry entry = ((CheckBoxListModel) getModel()).items.get(row);
    if (entry.caption)
        setFont(boldFont);
    else
        setFont(plainFont);
    return this;
}