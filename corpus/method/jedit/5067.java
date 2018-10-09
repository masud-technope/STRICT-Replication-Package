//}}}
//{{{ update() method
public void update(JMenu menu) {
    final View view = GUIUtilities.getView(menu);
    //{{{ ActionListeners
    ActionListener fileListener = new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
            jEdit.openFile(view, evt.getActionCommand());
        }
    };
    ActionListener dirListener = new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
            VFSBrowser.browseDirectory(view, evt.getActionCommand());
        }
    };
    VFSFile[] favorites = FavoritesVFS.getFavorites();
    if (favorites.length == 0) {
        JMenuItem mi = new JMenuItem(jEdit.getProperty("vfs.browser.favorites" + ".no-favorites.label"));
        mi.setEnabled(false);
        menu.add(mi);
    } else {
        Arrays.sort(favorites, new VFS.DirectoryEntryCompare(jEdit.getBooleanProperty("vfs.browser.sortMixFilesAndDirs"), jEdit.getBooleanProperty("vfs.browser.sortIgnoreCase")));
        for (VFSFile fav : favorites) {
            FavoritesVFS.Favorite favorite = (FavoritesVFS.Favorite) fav;
            JMenuItem mi = new JMenuItem(favorite.getLabel());
            mi.setActionCommand(favorite.getPath());
            mi.setIcon(FileCellRenderer.getIconForFile(favorite, false));
            if (favorite.getType() == VFSFile.FILE)
                mi.addActionListener(fileListener);
            else
                mi.addActionListener(dirListener);
            menu.add(mi);
        }
    }
}