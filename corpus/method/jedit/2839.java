/**
	 * Creates a new I/O request for markers.
	 * @param view The view
	 * @param buffer The buffer
	 * @param session The VFS session
	 * @param vfs The VFS
	 * @param path The path
	 */
public  MarkersSaveRequest(View view, Buffer buffer, Object session, VFS vfs, String path) {
    this.view = view;
    this.buffer = buffer;
    this.session = session;
    this.vfs = vfs;
    this.path = path;
    this.markersPath = Buffer.getMarkersPath(vfs, path);
}