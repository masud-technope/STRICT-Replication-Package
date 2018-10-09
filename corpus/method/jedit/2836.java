/**
	 * Creates a new buffer I/O request.
	 * @param view The view
	 * @param buffer The buffer
	 * @param session The VFS session
	 * @param vfs The VFS
	 * @param path The path
	 */
public  BufferSaveRequest(View view, Buffer buffer, Object session, VFS vfs, String path) {
    super(view, buffer, session, vfs, path);
}