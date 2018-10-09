//}}}
//{{{ getValueAt() method
public Object getValueAt(int row, int col) {
    Entry window = (Entry) windows.get(row);
    switch(col) {
        case 0:
            return window.title;
        case 1:
            return window.dockPosition;
        default:
            throw new InternalError();
    }
}