//}}}
//{{{ restoreSelection() method
private void restoreSelection(Set<Integer> selectedIndices) {
    if (selectedIndices == null || getRowCount() == 0)
        return;
    for (Integer selectedIndex : selectedIndices) {
        int i = getInternal2ExternalRow(selectedIndex.intValue());
        if (i != -1)
            table.getSelectionModel().setSelectionInterval(i, i);
    }
}