//}}}
//{{{ getNthBackupFile method
/**
	 * Gets the file to store the Nth backup of the given file.
	 * @param name The last part of the filename of the file being
	 *             backed up.
	 * @param backup The number of the current backup.
	 * @param backups Total number of backup copies.
	 * @since 5.0pre1
	 */
public static File getNthBackupFile(String name, int backup, int backups, String backupPrefix, String backupSuffix, String backupDirectory) {
    File backupFile;
    if (backupPrefix == null)
        backupPrefix = "";
    if (backupSuffix == null)
        backupSuffix = "";
    if (backups <= 1) {
        backupFile = new File(backupDirectory, backupPrefix + name + backupSuffix);
    } else {
        backupFile = new File(backupDirectory, backupPrefix + name + backupSuffix + backup + backupSuffix);
    }
    return backupFile;
}