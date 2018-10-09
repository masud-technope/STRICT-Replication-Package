//}}}
//{{{ saveSelection()
protected Set<Integer> saveSelection() {
    if (list == null)
        return null;
    int[] rows = list.getSelectedIndices();
    if (rows.length == 0)
        return null;
    Set<Integer> selectedRows = new HashSet<Integer>(rows.length);
    for (int row : rows) {
        selectedRows.add(getTrueRow(row));
    }
    return selectedRows;
}