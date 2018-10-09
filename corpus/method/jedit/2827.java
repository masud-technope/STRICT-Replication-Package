/**
	 * Creates a new buffer I/O request.
	 * @param view The view
	 * @param buffer The buffer
	 * @param session The VFS session
	 * @param vfs The VFS
	 * @param path The path
	 * @param untitled is the buffer untitled
	 */
public  BufferLoadRequest(View view, Buffer buffer, Object session, VFS vfs, String path, boolean untitled) {
    super(view, buffer, session, vfs, path);
    this.untitled = untitled;
}