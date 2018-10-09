//}}}
//{{{ setValueAt() method
public void setValueAt(Object value, int row, int col) {
    Entry entry = entries.get(row);
    if (col == 0)
        entry.glob = (String) value;
    else
        entry.color = (Color) value;
    fireTableRowsUpdated(row, row);
}