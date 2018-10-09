/**
	 * Creates a new browser I/O request.
	 * @param browser The VFS browser instance
	 * @param path The first path name to operate on
	 */
 AbstractBrowserTask(VFSBrowser browser, Object session, VFS vfs, String path, Runnable awtTask) {
    this.browser = browser;
    this.session = session;
    this.vfs = vfs;
    this.path = path;
    if (awtTask != null) {
        MyTaskListener listener = new MyTaskListener(awtTask);
        TaskManager.instance.addTaskListener(listener);
    }
}