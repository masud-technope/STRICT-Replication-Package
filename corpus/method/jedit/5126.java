//}}}
//{{{ saveBackup() methods
/**
	 * Saves a backup (optionally numbered) of a file. Reads
	 * jedit properties to determine backup parameters, like
	 * prefix, suffix, directory.
	 * <p>This version calls
	 * <code>prepareBackupDirectory</code>.
	 * @param file A local file
	 * @since jEdit 5.0pre1
	 */
public static void saveBackup(File file) {
    File backupDir = prepareBackupDirectory(file.toString());
    File backupFile = prepareBackupFile(file.toString(), backupDir);
    if (backupFile != null)
        saveBackup(file, backupFile);
}