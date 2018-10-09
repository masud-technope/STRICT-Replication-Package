//{{{ setSelectAll() method
public void setSelectAll(boolean b) {
    if (isDownloadingList())
        return;
    int length = getRowCount();
    for (int i = 0; i < length; i++) {
        if (b)
            setValueAt(Boolean.TRUE, i, 0);
        else {
            Entry entry = (Entry) filteredEntries.get(i);
            entry.dependents = new LinkedList<Entry>();
            entry.install = false;
        }
    }
    fireTableChanged(new TableModelEvent(this));
//}}}
}