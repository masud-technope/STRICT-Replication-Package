/**
	 * Prepares the filename for performing backup of the given file.
	 * In case of multiple backups does necessary backup renumbering.
	 * Checks whether the last backup was not earlier than
	 * <code>backupTimeDistance</code> ms ago.
	 * @param path The file to back up.
	 * @param backups The number of backups. Must be &gt;= 1. If &gt; 1, backup
	 * files will be numbered.
	 * @param backupDirectory The directory determined externally or
	 * obtained from <code>prepareBackupDirectory</code>.
	 * @return File suitable for backup of <code>file</code>,
	           or <code>null</code> if the last backup was
	           less than <code>backupTimeDistance</code> ms ago.
	 * @since 5.0pre1
	 */
public static File prepareBackupFile(String path, int backups, String backupPrefix, String backupSuffix, String backupDirectory, int backupTimeDistance) {
    File file;
    boolean isLocal = VFSManager.getVFSForPath(path) instanceof FileVFS;
    if (isLocal)
        file = new File(path);
    else
        file = new File(replaceNonPathChars(path, "_"));
    String name = file.getName();
    File backupFile = getNthBackupFile(name, 1, backups, backupPrefix, backupSuffix, backupDirectory);
    if (backupFile.equals(file)) {
        Log.log(Log.WARNING, MiscUtilities.class, jEdit.getProperty("ioerror.backup-same-name") + " " + jEdit.getProperty("ioerror.backup-failed"));
        return null;
    }
    long modTime = backupFile.lastModified();
    /* if backup file was created less than
		* 'backupTimeDistance' ago, we do not
		* create the backup */
    if (System.currentTimeMillis() - modTime < backupTimeDistance) {
        Log.log(Log.DEBUG, MiscUtilities.class, "Backup not done because of backup.minTime");
        return null;
    }
    File lastBackup = getNthBackupFile(name, backups, backups, backupPrefix, backupSuffix, backupDirectory);
    // not to delete the original file.
    if (!lastBackup.equals(file))
        lastBackup.delete();
    if (backups > 1) {
        for (int i = backups - 1; i > 0; i--) {
            File backup1 = getNthBackupFile(name, i, backups, backupPrefix, backupSuffix, backupDirectory);
            File backup2 = getNthBackupFile(name, i + 1, backups, backupPrefix, backupSuffix, backupDirectory);
            backup1.renameTo(backup2);
        }
    }
    return backupFile;
}