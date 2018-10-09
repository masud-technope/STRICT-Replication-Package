@Override
public void setValueAt(Object value, int row, int col) {
    if (col == 0) {
        JCheckBoxList.Entry entry = items.get(row);
        if (!entry.caption) {
            entry.checked = value.equals(Boolean.TRUE);
            fireTableRowsUpdated(row, row);
        }
    }
}