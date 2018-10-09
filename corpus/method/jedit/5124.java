//}}}
//{{{ prepareBackupFile methods
/**
	 * Prepares the filename for performing backup of the given file.
	 * In case of multiple backups does necessary backup renumbering.
	 * Checks whether the last backup was not earlier than
	 * <code>backup.minTime</code> (property) ms ago.
	 * Uses jedit properties to determine backup parameters,
	 * like prefix, suffix.
	 * @param path The file to back up.
	 * @param backupDir The directory, usually obtained from
	 *                  <code>prepareBackupDirectory</code>.
	 * @return File suitable for backup of <code>file</code>,
	           or <code>null</code> if the last backup was
	           less than <code>backup.minTime</code> ms ago.
	 * @since 5.0pre1
	 */
public static File prepareBackupFile(String path, File backupDir) {
    // read properties
    int backups = jEdit.getIntegerProperty("backups", 1);
    String backupPrefix = jEdit.getProperty("backup.prefix");
    String backupSuffix = jEdit.getProperty("backup.suffix");
    int backupTimeDistance = jEdit.getIntegerProperty("backup.minTime", 0);
    return prepareBackupFile(path, backups, backupPrefix, backupSuffix, backupDir.getPath(), backupTimeDistance);
}