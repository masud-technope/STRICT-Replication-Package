/**
	 * Saves a backup (optionally numbered) of a file. Requires
	 * specifying the backup directory and generates the backup filename.
	 * @param file A local file
	 * @param backups The number of backups. Must be &gt;= 1. If &gt; 1, backup
	 * files will be numbered.
	 * @param backupPrefix The backup file name prefix
	 * @param backupSuffix The backup file name suffix
	 * @param backupDirectory The directory where to save backups; if null,
	 * they will be saved in the same directory as the file itself.
	 * @param backupTimeDistance The minimum time in minutes when a backup
	 * version 1 shall be moved into version 2; if 0, backups are always
	 * moved.
	 * @since jEdit 4.2pre5
	 */
public static void saveBackup(File file, int backups, String backupPrefix, String backupSuffix, String backupDirectory, int backupTimeDistance) {
    File backupFile = prepareBackupFile(file.toString(), backups, backupPrefix, backupSuffix, backupDirectory, backupTimeDistance);
    if (backupFile == null)
        return;
    saveBackup(file, backupFile);
}