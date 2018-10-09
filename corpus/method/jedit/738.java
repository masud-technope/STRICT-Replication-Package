//}}}
//{{{ run() method
@Override
public void _run() {
    try {
        setCancellable(true);
        String[] args = { path };
        setStatus(jEdit.getProperty("vfs.status.deleting", args));
        path = vfs._canonPath(session, path, browser);
        if (!vfs._delete(session, path, browser))
            VFSManager.error(browser, path, "ioerror.delete-error", null);
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