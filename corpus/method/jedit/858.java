//{{{ selectFile() method
public boolean selectFile(String path) {
    for (int i = 0; i < getRowCount(); i++) {
        Entry entry = (Entry) getValueAt(i, 1);
        if (entry.dirEntry.getPath().equals(path)) {
            setSelectedRow(i);
            return true;
        }
    }
    return false;
}