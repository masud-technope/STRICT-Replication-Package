// }}}
//{{{ prepareBackupDirectory method
/**
	 * Prepares the directory to backup the specified file.
	 * A jEdit property is used to determine the directory.
	 * If there is no dedicated backup directory specified by props,
	 * then the current directory is used, but only for local files.
	 * The directory is created if it does not exist.
	 * @param path path to the buffer
	 * @return Backup directory. <code>null</code> is returned for
	 * non-local files if no backup directory is specified in properties.
	 * @since 5.0pre1
	 */
public static File prepareBackupDirectory(String path) {
    boolean isLocal = VFSManager.getVFSForPath(path) instanceof FileVFS;
    File file;
    if (isLocal)
        file = new File(path);
    else
        file = new File(replaceNonPathChars(path, "_"));
    File dir = file;
    if (!dir.isDirectory())
        dir = dir.getParentFile();
    // Check for backup.directory
    String backupDirectory = getBackupDirectory();
    if (backupDirectory == null) {
        if (!isLocal)
            return null;
    } else {
        if (path.startsWith(backupDirectory))
            return dir;
        // Perhaps here we would want to guard with
        // a property for parallel backups or not.
        backupDirectory = MiscUtilities.concatPath(backupDirectory, dir.getAbsolutePath());
        dir = new File(backupDirectory);
        if (!dir.exists())
            dir.mkdirs();
    }
    return dir;
}