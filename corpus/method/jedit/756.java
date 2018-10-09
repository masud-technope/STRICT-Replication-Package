//}}}
//{{{ run() method
@Override
public void _run() {
    String[] args = { path };
    try {
        setCancellable(true);
        setStatus(jEdit.getProperty("vfs.status.mkdir", args));
        path = vfs._canonPath(session, path, browser);
        if (!vfs._mkdir(session, path, browser))
            VFSManager.error(browser, path, "ioerror.mkdir-error", null);
    } catch (IOException io) {
        setCancellable(false);
        Log.log(Log.ERROR, this, io);
        args[0] = io.toString();
        VFSManager.error(browser, path, "ioerror", args);
    } finally {
        try {
            vfs._endVFSSession(session, browser);
        } catch (IOException io) {
            setCancellable(false);
            Log.log(Log.ERROR, this, io);
            args[0] = io.toString();
            VFSManager.error(browser, path, "ioerror", args);
        }
    }
}