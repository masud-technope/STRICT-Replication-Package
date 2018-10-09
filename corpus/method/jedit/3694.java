@Override
public boolean isCellEditable(int row, int col) {
    JCheckBoxList.Entry entry = items.get(row);
    return col == 0 && !entry.caption;
}