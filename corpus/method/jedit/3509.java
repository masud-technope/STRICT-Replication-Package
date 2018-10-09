//}}}
//{{{ restoreSelection() method
protected void restoreSelection(Set<Integer> selectedIndices) {
    if (selectedIndices == null || getSize() == 0)
        return;
    // To correctly handle "single interval" selection mode,
    // each interval has to be selected using a single call to
    // setSelectionInterval; calling setSelectionInterval on
    // each item cancels the previous selection.
    // Sort the list of selected indices to simplify interval
    // identification.
    Vector<Integer> sel = new Vector<Integer>(selectedIndices);
    Collections.sort(sel);
    int from = -1;
    int to = -1;
    for (Integer selectedIndex : sel) {
        int i = getInternal2ExternalRow(selectedIndex.intValue());
        if (i != -1) {
            if (from == -1)
                from = to = i;
            else if (i == to + 1)
                to = i;
            else {
                list.setSelectionInterval(from, to);
                from = to = i;
            }
        }
    }
    if (from != -1)
        list.setSelectionInterval(from, to);
}