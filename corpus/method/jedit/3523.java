//{{{ FilteredTableModel() constructor
protected  FilteredListModel(E delegated) {
    this.delegated = delegated;
    delegated.addListDataListener(this);
    resetFilter();
}