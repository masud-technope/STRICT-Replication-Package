//{{{ createPopupMenu() method
void createPopupMenu() {
    popup = new JPopupMenu();
    ActionHandler actionHandler = new ActionHandler();
    JMenuItem mi = new JMenuItem(jEdit.getProperty("vfs.browser.favorites.add-to-favorites.label"));
    mi.setActionCommand("add-to-favorites");
    mi.addActionListener(actionHandler);
    popup.add(mi);
    mi = new JMenuItem(jEdit.getProperty("vfs.browser.favorites.edit-favorites.label"));
    mi.setActionCommand("dir@favorites:");
    mi.addActionListener(actionHandler);
    popup.add(mi);
    popup.addSeparator();
    VFSFile[] favorites = FavoritesVFS.getFavorites();
    if (favorites.length == 0) {
        mi = new JMenuItem(jEdit.getProperty("vfs.browser.favorites.no-favorites.label"));
        mi.setEnabled(false);
        popup.add(mi);
    } else {
        Arrays.sort(favorites, new VFS.DirectoryEntryCompare(sortMixFilesAndDirs, sortIgnoreCase));
        for (int i = 0; i < favorites.length; i++) {
            FavoritesVFS.Favorite favorite = (FavoritesVFS.Favorite) favorites[i];
            mi = new JMenuItem(favorite.getLabel());
            mi.setIcon(FileCellRenderer.getIconForFile(favorite, false));
            String cmd = (favorite.getType() == VFSFile.FILE ? "file@" : "dir@") + favorite.getPath();
            mi.setActionCommand(cmd);
            mi.addActionListener(actionHandler);
            popup.add(mi);
        }
    }
//}}}
}