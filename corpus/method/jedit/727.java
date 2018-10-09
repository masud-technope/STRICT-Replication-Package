//}}}
//{{{ maybeReloadDirectory() method
public void maybeReloadDirectory(String path) {
    String browserDir = browser.getDirectory();
    String symlinkBrowserDir;
    if (MiscUtilities.isURL(browserDir)) {
        symlinkBrowserDir = browserDir;
    } else {
        symlinkBrowserDir = MiscUtilities.resolveSymlinks(browserDir);
    }
    if (MiscUtilities.pathsEqual(path, symlinkBrowserDir)) {
        saveExpansionState();
        loadDirectory(null, browserDir, false);
    }
    if (!browserDir.startsWith(FavoritesVFS.PROTOCOL) && !browserDir.startsWith(FileRootsVFS.PROTOCOL) && !path.startsWith(symlinkBrowserDir))
        return;
    if (browserDir.startsWith(FileRootsVFS.PROTOCOL) && MiscUtilities.isURL(path) && !"file".equals(MiscUtilities.getProtocolOfURL(path)))
        return;
    table.maybeReloadDirectory(path);
}