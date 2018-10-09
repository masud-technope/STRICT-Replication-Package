//}}}
//{{{ initModels() method
private void initModels() {
    filteredModel = new FilteredTableModel<ShortcutsModel>() {

        @Override
        public String prepareFilter(String filter) {
            return filter.toLowerCase();
        }

        @Override
        public boolean passFilter(int row, String filter) {
            String name = delegated.getBindingAt(row, 0).label.toLowerCase();
            return name.contains(filter);
        }
    };
    models = new Vector();
    reloadModels();
}