//}}}
//{{{ setValueAt() method
public void setValueAt(Object value, int row, int col) {
    if (col == 0)
        return;
    Entry window = (Entry) windows.get(row);
    switch(col) {
        case 1:
            window.dockPosition = (String) value;
            break;
        default:
            throw new InternalError();
    }
    fireTableRowsUpdated(row, row);
}