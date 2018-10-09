//}}}
//{{{ run() method
public void _run() {
    OutputStream out = null;
    try {
        String[] args = { vfs.getFileName(path) };
        setStatus(jEdit.getProperty("vfs.status.autosave", args));
        // the entire save operation can be aborted...
        setCancellable(true);
        try {
            buffer.readLock();
            if (buffer.isDirty())
                out = vfs._createOutputStream(session, path, view);
            if (out != null) {
                Log.log(Log.DEBUG, MiscUtilities.class, "Saving autosave of file \"" + buffer.getPath() + "\" to \"" + path + '"');
                write(buffer, out);
            }
        } catch (FileNotFoundException e) {
            Log.log(Log.WARNING, this, "Unable to save " + e.getMessage());
        } catch (InterruptedException e) {
            cleanUpIncomplete(out);
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            Log.log(Log.ERROR, this, e);
            String[] pp = { e.toString() };
            VFSManager.error(view, path, "ioerror.write-error", pp);
            cleanUpIncomplete(out);
        } finally {
            buffer.readUnlock();
        }
    } finally {
        IOUtilities.closeQuietly((Closeable) out);
    }
}