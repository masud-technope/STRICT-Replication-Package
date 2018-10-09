//}}}
//{{{ setFilter() method
public void setFilter(@Nullable final String filter) {
    Runnable runner = new Runnable() {

        public void run() {
            Set<Integer> selectedIndices = saveSelection();
            list.clearSelection();
            FilteredListModel.this.filter = filter;
            if (filter != null && !filter.isEmpty()) {
                int size = delegated.getSize();
                String prepped_filter = prepareFilter(filter);
                Vector<Integer> indices = new Vector<Integer>(size);
                Map<Integer, Integer> invertedIndices = new HashMap<Integer, Integer>();
                for (int i = 0; i < size; i++) {
                    if (passFilter(i, prepped_filter)) {
                        Integer delegatedIndice = Integer.valueOf(i);
                        indices.add(delegatedIndice);
                        invertedIndices.put(delegatedIndice, indices.size() - 1);
                    }
                }
                FilteredListModel.this.invertedIndices = invertedIndices;
                filteredIndices = indices;
            } else
                resetFilter();
            fireContentsChanged(FilteredListModel.this, 0, getSize() - 1);
            restoreSelection(selectedIndices);
        }
    };
    SwingUtilities.invokeLater(runner);
}