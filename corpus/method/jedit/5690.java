//{{{ sort() method
public void sort(int type) {
    List<String> savedSelection = new ArrayList<String>();
    saveSelection(savedSelection);
    if (sortType != type) {
        sortDirection = 1;
    }
    sortType = type;
    Collections.sort(entries, new EntryCompare(type, sortDirection));
    fireTableChanged(new TableModelEvent(this));
    restoreSelection(savedSelection);
    table.getTableHeader().repaint();
}