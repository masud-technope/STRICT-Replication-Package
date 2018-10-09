//}}}
//{{{ saveSelection()
private Set<Integer> saveSelection() {
    if (table == null)
        return null;
    int[] rows = table.getSelectedRows();
    if (rows.length == 0)
        return null;
    Set<Integer> selectedRows = new HashSet<Integer>(rows.length);
    for (int row : rows) {
        selectedRows.add(getTrueRow(row));
    }
    return selectedRows;
}