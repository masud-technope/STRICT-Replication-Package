//}}}
//{{{ load() method
/**
	 * Loads the specified buffer. The default implementation posts
	 * an I/O request to the I/O thread.
	 * @param view The view
	 * @param buffer The buffer
	 * @param path The path
	 * @param untitled is the buffer untitled
	 */
public boolean load(View view, Buffer buffer, String path, boolean untitled) {
    if ((getCapabilities() & READ_CAP) == 0) {
        VFSManager.error(view, path, "vfs.not-supported.load", new String[] { name });
        return false;
    }
    Object session = createVFSSession(path, view);
    if (session == null)
        return false;
    if ((getCapabilities() & WRITE_CAP) == 0)
        buffer.setReadOnly(true);
    Task request = new BufferLoadRequest(view, buffer, session, this, path, untitled);
    if (buffer.isTemporary())
        // this makes HyperSearch much faster
        request.run();
    else
        // BufferLoadRequest can cause UI interations (for example FTP connection dialog),
        // so it should be runned in Dispatch thread
        //ThreadUtilities.runInDispatchThread(request);
        ThreadUtilities.runInBackground(request);
    return true;
}