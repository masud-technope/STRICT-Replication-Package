@Override
public void setValueAt(Object value, int row, int col) {
    if (col == 0)
        return;
    getBindingAt(row, col - 1).shortcut = (String) value;
    // redraw the whole table because a second shortcut
    // might have changed, too
    fireTableDataChanged();
}