//}}}
//{{{ loadDirectory() method
public void loadDirectory(final Object node, String path, final boolean addToHistory, final Runnable delayedAWTTask) {
    path = MiscUtilities.constructPath(browser.getDirectory(), path);
    VFS vfs = VFSManager.getVFSForPath(path);
    Object session = vfs.createVFSSession(path, this);
    if (session == null) {
        if (delayedAWTTask != null)
            ThreadUtilities.runInDispatchThread(delayedAWTTask);
        return;
    }
    if (node == null) {
        parentDirectories.setListData(new Object[] { new LoadingPlaceholder() });
    }
    final Object[] loadInfo = new Object[2];
    Runnable awtRunnable = new Runnable() {

        public void run() {
            browser.directoryLoaded(node, loadInfo, addToHistory);
            if (delayedAWTTask != null)
                delayedAWTTask.run();
        }
    };
    ThreadUtilities.runInBackground(new ListDirectoryBrowserTask(browser, session, vfs, path, loadInfo, awtRunnable));
}