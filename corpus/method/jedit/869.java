@Override
public void mouseClicked(MouseEvent evt) {
    // double click on columns header
    if (evt.getSource() == header && evt.getClickCount() == 2) {
        VFSDirectoryEntryTableModel model = (VFSDirectoryEntryTableModel) header.getTable().getModel();
        TableColumnModel columnModel = header.getColumnModel();
        int viewColumnIndex = columnModel.getColumnIndexAtX(evt.getX());
        // View index must be used here instead of model index because model order is rearranged by custom code
        // on column move according to view order so that both are equal, but no "structurechanged" is triggered,
        // so view order is the same as model order (maintained by custom code, while JTable's automatic
        // indexing is wrong here) before sortByColumn call finishes, where sortColumnIndex is saved
        // and structureChanged is triggered.
        //
        // If use modelIndex, the bug will arise (sort by column, move that column, sort again, result: sorting
        // mark is at wrong column)
        int modelColumnIndex = viewColumnIndex;
        saveWidths();
        if (model.sortByColumn(modelColumnIndex)) {
            resizeColumns();
            Log.log(Log.DEBUG, this, "VFSDirectoryEntryTable sorted by " + model.getColumnName(modelColumnIndex) + (model.getAscending() ? " ascending" : " descending"));
        }
    }
}