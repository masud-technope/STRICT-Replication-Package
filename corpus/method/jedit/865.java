//}}}
//{{{ maybeReloadDirectory() method
public void maybeReloadDirectory(String path) {
    VFSDirectoryEntryTableModel model = (VFSDirectoryEntryTableModel) getModel();
    for (int i = 0; i < model.files.length; i++) {
        Entry e = model.files[i];
        if (!e.expanded || e.dirEntry.getType() == VFSFile.FILE)
            continue;
        VFSFile dirEntry = e.dirEntry;
        // work around for broken FTP plugin!
        String otherPath;
        if (dirEntry.getSymlinkPath() == null)
            otherPath = dirEntry.getPath();
        else
            otherPath = dirEntry.getSymlinkPath();
        if (MiscUtilities.pathsEqual(path, otherPath)) {
            browserView.saveExpansionState();
            browserView.loadDirectory(e, path, false);
            return;
        }
    }
}