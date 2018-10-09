//}}}
//{{{ getTableCellRendererComponent() method
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    if (value instanceof VFSDirectoryEntryTableModel.Entry) {
        VFSDirectoryEntryTableModel.Entry entry = (VFSDirectoryEntryTableModel.Entry) value;
        VFSFile file = entry.dirEntry;
        setFont(file.getType() == VFSFile.FILE ? plainFont : boldFont);
        this.isSelected = isSelected;
        this.file = file;
        if (column == 0) {
            // while its broken to have a null
            // symlinkPath, some older plugins
            // might...
            String path;
            if (file.getSymlinkPath() == null)
                path = file.getPath();
            else
                path = file.getSymlinkPath();
            openBuffer = jEdit._getBuffer(path) != null;
            setIcon(showIcons ? getIconForFile(file, entry.expanded, openBuffer) : null);
            if (file instanceof FavoritesVFS.Favorite) {
                FavoritesVFS.Favorite favorite = (FavoritesVFS.Favorite) file;
                setText(favorite.getLabel());
            } else {
                setText(file.getName());
            }
            int state;
            if (file.getType() == VFSFile.FILE)
                state = ExpansionToggleBorder.STATE_NONE;
            else if (entry.expanded)
                state = ExpansionToggleBorder.STATE_EXPANDED;
            else
                state = ExpansionToggleBorder.STATE_COLLAPSED;
            setBorder(new ExpansionToggleBorder(state, entry.level));
        } else {
            VFSDirectoryEntryTableModel model = (VFSDirectoryEntryTableModel) table.getModel();
            String extAttr = model.getExtendedAttribute(column);
            openBuffer = false;
            setIcon(null);
            setText(file.getExtendedAttribute(extAttr));
            setBorder(new EmptyBorder(1, 1, 1, 1));
        }
    }
    return this;
}