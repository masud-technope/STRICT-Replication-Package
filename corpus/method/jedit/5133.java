/**
	 * Saves a backup of a local file. Requires
	 * specifying source and destination files.
	 * @param file A local file
	 * @param backupFile A local backup file.
	 * @since jEdit 5.0pre1
	 */
public static void saveBackup(File file, File backupFile) {
    Log.log(Log.DEBUG, MiscUtilities.class, "Saving backup of file \"" + file.getAbsolutePath() + "\" to \"" + backupFile.getAbsolutePath() + '"');
    if (!file.renameTo(backupFile))
        IOUtilities.moveFile(file, backupFile);
}