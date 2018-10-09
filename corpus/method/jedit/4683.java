//}}}
//{{{ findCompletion() method
public static String findCompletion(String path, String complete, VFSBrowser browser, boolean dirsOnly) {
    Log.log(Log.DEBUG, VFSFile.class, "findCompletion(" + path + ',' + complete + ',' + dirsOnly + ')');
    if (complete.equals("~"))
        return System.getProperty("user.home");
    else if (complete.equals("-"))
        return browser.getView().getBuffer().getDirectory();
    else if (complete.equals(".."))
        return MiscUtilities.getParentOfPath(path);
    if (MiscUtilities.isAbsolutePath(complete)) {
        if (MiscUtilities.isURL(complete))
            return complete;
        else
            path = "roots:";
    }
    VFS vfs = VFSManager.getVFSForPath(path);
    if ((vfs.getCapabilities() & VFS.LOW_LATENCY_CAP) == 0)
        return null;
    Object session = vfs.createVFSSession(path, browser);
    if (session == null)
        return null;
    try {
        VFSFile[] files = vfs._listFiles(session, path, browser);
        int index = findCompletion(files, 0, files.length, complete, dirsOnly);
        if (index != -1)
            return files[index].path;
    } catch (IOException e) {
        VFSManager.error(e, path, browser);
    } finally {
        try {
            vfs._endVFSSession(session, browser);
        } catch (IOException e) {
            VFSManager.error(e, path, browser);
        }
    }
    return null;
}