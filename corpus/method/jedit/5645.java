//{{{ sort() method
public void sort(int type) {
    Set<String> savedChecked = new HashSet<String>();
    Set<String> savedSelection = new HashSet<String>();
    saveSelection(savedChecked, savedSelection);
    if (sortType != type) {
        sortDirection = 1;
    }
    sortType = type;
    Collections.sort(entries, new EntryCompare(type, sortDirection));
    updateFilteredEntries();
    restoreSelection(savedChecked, savedSelection);
    table.getTableHeader().repaint();
}