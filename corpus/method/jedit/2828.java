//}}}
//{{{ run() method
public void _run() {
    try {
        setCancellable(true);
        if (!buffer.isTemporary()) {
            String[] args = { vfs.getFileName(path) };
            setStatus(jEdit.getProperty("vfs.status.load", args));
            setValue(0L);
        }
        path = vfs._canonPath(session, path, view);
        readContents();
        buffer.setNewFile(untitled);
        if (jEdit.getBooleanProperty("persistentMarkers") && (vfs.isMarkersFileSupported())) {
            InputStream markers = null;
            try {
                String[] args = { vfs.getFileName(path) };
                if (!buffer.isTemporary())
                    setStatus(jEdit.getProperty("vfs.status.load-markers", args));
                setCancellable(true);
                markers = vfs._createInputStream(session, markersPath, true, view);
                if (markers != null)
                    readMarkers(buffer, markers);
            } catch (Exception e) {
            } finally {
                IOUtilities.closeQuietly(markers);
            }
        }
    } catch (InterruptedException e) {
        buffer.setBooleanProperty(ERROR_OCCURRED, true);
        Thread.currentThread().interrupt();
    } catch (Exception e) {
        Log.log(Log.ERROR, this, e);
        Object[] pp = { e.toString() };
        VFSManager.error(view, path, "ioerror.read-error", pp);
        buffer.setBooleanProperty(ERROR_OCCURRED, true);
    } catch (OutOfMemoryError oom) {
        Log.log(Log.ERROR, this, oom);
        VFSManager.error(view, path, "out-of-memory-error", null);
        buffer.setBooleanProperty(ERROR_OCCURRED, true);
    } finally {
        endSessionQuietly();
    }
}