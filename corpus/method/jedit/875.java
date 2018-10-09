public void columnMoved(TableColumnModelEvent e) {
    // view indexes
    ((VFSDirectoryEntryTableModel) getModel()).columnMoved(e.getFromIndex(), e.getToIndex());
}