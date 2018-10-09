//}}}
//{{{ maybeReload() method
private void maybeReload(String path) {
    String originalPath = path;
    String jEditHome = jEdit.getJEditHome();
    String settingsDirectory = jEdit.getSettingsDirectory();
    // On Windows and MacOS, path names are case insensitive
    if ((VFSManager.getVFSForPath(path).getCapabilities() & VFS.CASE_INSENSITIVE_CAP) != 0) {
        path = path.toLowerCase();
        jEditHome = jEditHome.toLowerCase();
        if (settingsDirectory != null)
            settingsDirectory = settingsDirectory.toLowerCase();
    }
    // XXX: does this really belong here?
    SearchFileSet fileset = SearchAndReplace.getSearchFileSet();
    if (fileset instanceof DirectoryListSet) {
        DirectoryListSet dirset = (DirectoryListSet) fileset;
        String dir = MiscUtilities.resolveSymlinks(dirset.getDirectory());
        if (path.startsWith(dir))
            dirset.invalidateCachedList();
    }
    if (jEditHome != null && path.startsWith(jEditHome))
        path = path.substring(jEditHome.length());
    else if (settingsDirectory != null && path.startsWith(settingsDirectory))
        path = path.substring(settingsDirectory.length());
    else {
        // no need to reload anything.
        return;
    }
    if (path.startsWith(File.separator) || path.startsWith("/"))
        path = path.substring(1);
    if (path.startsWith("macros"))
        Macros.loadMacros();
    else if (path.startsWith("modes") && (path.endsWith(".xml") || path.endsWith("catalog")))
        jEdit.reloadModes();
}