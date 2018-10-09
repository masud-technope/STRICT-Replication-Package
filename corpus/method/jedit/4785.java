/**
	 * Creates a new `untitled' file.
	 *
	 * @param editPane The editPane to create the file in
	 *
	 * @return the new buffer
	 * @since jEdit 4.3pre17
	 */
public static Buffer newFile(EditPane editPane) {
    String path;
    if (editPane != null && editPane.getBuffer() != null) {
        path = editPane.getBuffer().getDirectory();
    } else {
        File backupDir = MiscUtilities.prepareBackupDirectory(System.getProperty("user.home"));
        path = backupDir.getPath();
    }
    VFS vfs = VFSManager.getVFSForPath(path);
    // if current file is on SQL VFS or something
    if ((vfs.getCapabilities() & VFS.WRITE_CAP) == 0)
        path = System.getProperty("user.home");
    return newFile(editPane, path);
}