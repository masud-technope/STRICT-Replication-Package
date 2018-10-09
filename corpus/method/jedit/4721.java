//}}}
//{{{ sendVFSUpdate() method
/**
	 * Sends a VFS update message.
	 * @param vfs The VFS
	 * @param path The path that changed
	 * @param parent True if an update should be sent for the path's
	 * parent too
	 * @since jEdit 2.6pre4
	 */
public static void sendVFSUpdate(VFS vfs, String path, boolean parent) {
    if (parent) {
        sendVFSUpdate(vfs, vfs.getParentOfPath(path), false);
        sendVFSUpdate(vfs, path, false);
    } else {
        // have to do this hack until VFSPath class is written
        if (path.length() != 1 && (path.endsWith("/") || path.endsWith(java.io.File.separator)))
            path = path.substring(0, path.length() - 1);
        synchronized (vfsUpdateLock) {
            for (VFSUpdate msg : vfsUpdates) {
                if (msg.getPath().equals(path)) {
                    // for the same path
                    return;
                }
            }
            vfsUpdates.add(new VFSUpdate(path));
            if (vfsUpdates.size() == 1) {
                // we were the first to add an update;
                // add update sending runnable to AWT
                // thread
                AwtRunnableQueue.INSTANCE.runAfterIoTasks(new SendVFSUpdatesSafely());
            }
        }
    }
}