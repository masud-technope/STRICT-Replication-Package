//}}}
//{{{ run() method
@Override
public void _run() {
    String[] args = { path };
    setStatus(jEdit.getProperty("vfs.status.listing-directory", args));
    String canonPath = path;
    VFSFile[] directory = null;
    try {
        setCancellable(true);
        canonPath = vfs._canonPath(session, path, browser);
        directory = vfs._listFiles(session, canonPath, browser);
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
    setCancellable(false);
    loadInfo[0] = canonPath;
    loadInfo[1] = directory;
}