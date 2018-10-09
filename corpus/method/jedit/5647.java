//{{{ saveSelection() method
public void saveSelection(Set<String> savedChecked, Set<String> savedSelection) {
    if (entries.isEmpty())
        return;
    for (int i = 0, c = getRowCount(); i < c; i++) {
        if ((Boolean) getValueAt(i, 0)) {
            savedChecked.add(filteredEntries.get(i).toString());
        }
    }
    int[] rows = table.getSelectedRows();
    for (int row : rows) {
        savedSelection.add(filteredEntries.get(row).toString());
    }
//}}}
}