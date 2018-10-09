//}}}
//{{{ maybeReloadDirectory() method
private void maybeReloadDirectory(String dir) {
    if (MiscUtilities.isURL(dir) && MiscUtilities.getProtocolOfURL(dir).equals(FavoritesVFS.PROTOCOL) && favorites != null) {
        favorites.popup = null;
    }
    // directory if request already active
    if (maybeReloadRequestRunning) {
        //Log.log(Log.WARNING,this,"VFS update: request already in progress");
        return;
    }
    // and before the path is set.
    if (path != null) {
        try {
            maybeReloadRequestRunning = true;
            browserView.maybeReloadDirectory(dir);
        } finally {
            // Do not change this until all VFS Browser tasks are
            // done in ThreadUtilities
            AwtRunnableQueue.INSTANCE.runAfterIoTasks(new Runnable() {

                public void run() {
                    maybeReloadRequestRunning = false;
                }
            });
        }
    }
}