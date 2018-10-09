//}}}
//{{{ run() method
@Override
public void _run() {
    OutputStream out = null;
    try {
        // Otherwise, we will accumilate stale marks files.
        if ((vfs.getCapabilities() & VFS.DELETE_CAP) != 0) {
            if (buffer.getMarkers().isEmpty())
                vfs._delete(session, markersPath, view);
            else {
                String[] args = { vfs.getFileName(path) };
                setStatus(jEdit.getProperty("vfs.status.save-markers", args));
                out = vfs._createOutputStream(session, markersPath, view);
                if (out != null)
                    writeMarkers(out);
            }
        }
    } catch (IOException io) {
        Log.log(Log.ERROR, this, io);
        buffer.setBooleanProperty(ERROR_OCCURRED, true);
    } finally {
        IOUtilities.closeQuietly((Closeable) out);
    }
}