//}}}
//{{{ getValueAt() method
public Object getValueAt(int row, int col) {
    Entry entry = entries.get(row);
    switch(col) {
        case 0:
            return entry.glob;
        case 1:
            return entry.color;
        default:
            return null;
    }
}