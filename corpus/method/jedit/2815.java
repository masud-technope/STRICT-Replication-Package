//}}}
//{{{ run() method
public void _run() {
    InputStream in = null;
    try {
        String[] args = { vfs.getFileName(path) };
        setStatus(jEdit.getProperty("vfs.status.load", args));
        setCancellable(true);
        path = vfs._canonPath(session, path, view);
        VFSFile entry = vfs._getFile(session, path, view);
        long length;
        if (entry != null)
            length = entry.getLength();
        else
            length = 0L;
        in = vfs._createInputStream(session, path, false, view);
        if (in == null)
            return;
        final SegmentBuffer seg = read(autodetect(in), length, true);
        /* we don't do this in Buffer.insert() so that
			   we can insert multiple files at once */
        AwtRunnableQueue.INSTANCE.runAfterIoTasks(new Runnable() {

            public void run() {
                view.getTextArea().setSelectedText(seg.toString());
            }
        });
    } catch (InterruptedException e) {
        buffer.setBooleanProperty(ERROR_OCCURRED, true);
        Thread.currentThread().interrupt();
    } catch (Exception e) {
        Log.log(Log.ERROR, this, e);
        String[] pp = { e.toString() };
        VFSManager.error(view, path, "ioerror.read-error", pp);
        buffer.setBooleanProperty(ERROR_OCCURRED, true);
    } finally {
        IOUtilities.closeQuietly((Closeable) in);
        endSessionQuietly();
    }
}