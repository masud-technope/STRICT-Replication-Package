//}}}
//{{{ setFilter() method
public void setFilter(String filter) {
    Set<Integer> selectedIndices = saveSelection();
    this.filter = filter;
    if (filter != null && !filter.isEmpty()) {
        int size = delegated.getRowCount();
        filter = prepareFilter(filter);
        Vector<Integer> indices = new Vector<Integer>(size);
        Map<Integer, Integer> invertedIndices = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++) {
            if (passFilter(i, filter)) {
                Integer delegatedIndice = Integer.valueOf(i);
                indices.add(delegatedIndice);
                invertedIndices.put(delegatedIndice, indices.size() - 1);
            }
        }
        this.invertedIndices = invertedIndices;
        filteredIndices = indices;
    } else
        resetFilter();
    fireTableDataChanged();
    restoreSelection(selectedIndices);
}