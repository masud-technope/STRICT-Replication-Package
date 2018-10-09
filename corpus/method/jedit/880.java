//}}}
//{{{ saveWidths() method
private void saveWidths() {
    if (resizingColumns)
        return;
    VFSDirectoryEntryTableModel model = (VFSDirectoryEntryTableModel) getModel();
    TableColumnModel columns = getColumnModel();
    for (int i = 1; i < model.getColumnCount(); i++) model.saveColumnWidth(i, columns.getColumn(i).getWidth());
}