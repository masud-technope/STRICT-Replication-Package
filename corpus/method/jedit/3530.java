//{{{ FilteredTableModel() constructors
protected  FilteredTableModel(E delegated) {
    this.delegated = delegated;
    delegated.addTableModelListener(this);
    resetFilter();
}