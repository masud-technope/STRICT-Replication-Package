/**
	 * Saves a backup (optionally numbered) of a file.
	 * @param file A local file
	 * @param backups The number of backups. Must be &gt;= 1. If &gt; 1, backup
	 * files will be numbered.
	 * @param backupPrefix The backup file name prefix
	 * @param backupSuffix The backup file name suffix
	 * @param backupDirectory The directory where to save backups; if null,
	 * they will be saved in the same directory as the file itself.
	 * @since jEdit 4.0pre1
	 */
public static void saveBackup(File file, int backups, String backupPrefix, String backupSuffix, String backupDirectory) {
    saveBackup(file, backups, backupPrefix, backupSuffix, backupDirectory, 0);
}