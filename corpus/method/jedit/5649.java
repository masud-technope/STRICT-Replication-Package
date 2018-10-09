//{{{ restoreSelection() method
public void restoreSelection(Set<String> savedChecked, Set<String> savedSelection) {
    for (int i = 0, c = getRowCount(); i < c; i++) {
        Object obj = filteredEntries.get(i);
        String name = obj.toString();
        if (obj instanceof Entry) {
            name = ((Entry) obj).plugin.jar;
        }
        if (pluginSet.contains(name))
            setValueAt(true, i, 0);
        else
            setValueAt(savedChecked.contains(name), i, 0);
    }
    if (table == null)
        return;
    table.setColumnSelectionInterval(0, 0);
    if (!savedSelection.isEmpty()) {
        int i = 0;
        int rowCount = getRowCount();
        for (; i < rowCount; i++) {
            String name = filteredEntries.get(i).toString();
            if (savedSelection.contains(name)) {
                table.setRowSelectionInterval(i, i);
                break;
            }
        }
        ListSelectionModel lsm = table.getSelectionModel();
        for (; i < rowCount; i++) {
            String name = filteredEntries.get(i).toString();
            if (savedSelection.contains(name)) {
                lsm.addSelectionInterval(i, i);
            }
        }
    } else {
        if (table.getRowCount() != 0)
            table.setRowSelectionInterval(0, 0);
        JScrollBar scrollbar = scrollpane.getVerticalScrollBar();
        scrollbar.setValue(scrollbar.getMinimum());
    }
//}}}
}