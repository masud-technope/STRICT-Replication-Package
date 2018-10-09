/**
	 * Creates a new browser I/O request.
	 * @param browser The VFS browser instance
	 * @param path The first path name to operate on
	 * @param loadInfo A two-element array filled out by the request;
	 * element 1 is the canonical path, element 2 is the file list.
	 */
 ListDirectoryBrowserTask(VFSBrowser browser, Object session, VFS vfs, String path, Object[] loadInfo, Runnable awtRunnable) {
    super(browser, session, vfs, path, awtRunnable);
    this.loadInfo = loadInfo;
}