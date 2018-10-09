//}}}
//{{{ _run() method
@Override
public void _run() {
    try {
        setCancellable(true);
        String[] args = { path, path2 };
        setStatus(jEdit.getProperty("vfs.status.renaming", args));
        path = vfs._canonPath(session, path, browser);
        path2 = vfs._canonPath(session, path2, browser);
        if (!(vfs instanceof FavoritesVFS)) {
            VFSFile file = vfs._getFile(session, path2, browser);
            if (file != null) {
                if ((OperatingSystem.isCaseInsensitiveFS()) && path.equalsIgnoreCase(path2)) {
                // allow user to change name
                // case
                } else {
                    VFSManager.error(browser, path, "ioerror.rename-exists", new String[] { path2 });
                    return;
                }
            }
        }
        if (!vfs._rename(session, path, path2, browser))
            VFSManager.error(browser, path, "ioerror.rename-error", new String[] { path2 });
    } catch (IOException io) {
        setCancellable(false);
        Log.log(Log.ERROR, this, io);
        String[] pp = { io.toString() };
        VFSManager.error(browser, path, "ioerror.directory-error", pp);
    } finally {
        try {
            vfs._endVFSSession(session, browser);
        } catch (IOException io) {
            setCancellable(false);
            Log.log(Log.ERROR, this, io);
            String[] pp = { io.toString() };
            VFSManager.error(browser, path, "ioerror.directory-error", pp);
        }
    }
}