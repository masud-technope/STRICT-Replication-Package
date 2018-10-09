/**
	 * Creates a new browser I/O request.
	 * @param browser The VFS browser instance
	 * @param path The first path name to operate on
	 */
 MkDirBrowserTask(VFSBrowser browser, Object session, VFS vfs, String path, Runnable awtRunnable) {
    super(browser, session, vfs, path, awtRunnable);
}