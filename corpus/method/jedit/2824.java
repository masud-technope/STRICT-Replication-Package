/**
	 * Creates a new buffer I/O request.
	 * @param view The view
	 * @param buffer The buffer
	 * @param session The VFS session
	 * @param vfs The VFS
	 * @param path The path
	 */
protected  BufferIORequest(View view, Buffer buffer, Object session, VFS vfs, String path) {
    super();
    this.view = view;
    this.buffer = buffer;
    this.session = session;
    this.vfs = vfs;
    this.path = path;
    markersPath = Buffer.getMarkersPath(vfs, path);
//buffer.setIoTask(this);
}