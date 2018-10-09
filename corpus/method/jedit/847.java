@Override
public void actionPerformed(ActionEvent evt) {
    String actionCommand = evt.getActionCommand();
    if ("add-to-favorites".equals(actionCommand)) {
        // if any directories are selected, add
        // them, otherwise add current directory
        VFSFile[] selected = getSelectedFiles();
        if (selected == null || selected.length == 0) {
            if (path.equals(FavoritesVFS.PROTOCOL + ':')) {
                GUIUtilities.error(VFSBrowser.this, "vfs.browser.recurse-favorites", null);
            } else {
                FavoritesVFS.addToFavorites(path, VFSFile.DIRECTORY);
            }
        } else {
            for (VFSFile file : selected) {
                FavoritesVFS.addToFavorites(file.getPath(), file.getType());
            }
        }
    } else if (actionCommand.startsWith("dir@")) {
        setDirectory(actionCommand.substring(4));
    } else if (actionCommand.startsWith("file@")) {
        switch(getMode()) {
            case BROWSER:
                jEdit.openFile(view, actionCommand.substring(5));
                break;
            default:
                locateFile(actionCommand.substring(5));
                break;
        }
    }
}