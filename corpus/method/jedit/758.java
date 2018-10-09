/**
	 * Creates a new browser I/O request.
	 *
	 * @param browser  The VFS browser instance
	 * @param path1    The first path name to operate on
	 * @param path2    The second path name to operate on
	 */
 RenameBrowserTask(VFSBrowser browser, Object session, VFS vfs, String path1, String path2, Runnable awtRunnable) {
    super(browser, session, vfs, path1, awtRunnable);
    this.path2 = path2;
}