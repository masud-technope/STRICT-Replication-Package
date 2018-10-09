//}}}
//{{{ resizeColumns() method
private void resizeColumns() {
    VFSDirectoryEntryTableModel model = (VFSDirectoryEntryTableModel) getModel();
    FontRenderContext fontRenderContext = new FontRenderContext(null, true, false);
    int[] widths = new int[model.getColumnCount()];
    for (int i = 0; i < widths.length; i++) {
        String columnName = model.getColumnName(i);
        if (columnName != null) {
            widths[i] = (int) renderer.plainFont.getStringBounds(columnName, fontRenderContext).getWidth();
        }
    }
    for (int i = 1; i < widths.length; i++) {
        //String extAttr = model.getExtendedAttribute(i);
        widths[i] = Math.max(widths[i], model.getColumnWidth(i));
    }
    for (int i = 0; i < model.files.length; i++) {
        Entry entry = model.files[i];
        Font font = entry.dirEntry.getType() == VFSFile.FILE ? renderer.plainFont : renderer.boldFont;
        widths[0] = Math.max(widths[0], renderer.getEntryWidth(entry, font, fontRenderContext));
    }
    widths[0] += 10;
    TableColumnModel columns = getColumnModel();
    try {
        resizingColumns = true;
        for (int i = 0; i < widths.length; i++) {
            columns.getColumn(i).setPreferredWidth(widths[i]);
            columns.getColumn(i).setWidth(widths[i]);
        }
    } finally {
        resizingColumns = false;
    }
    doLayout();
}