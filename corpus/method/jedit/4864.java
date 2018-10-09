//}}}
//{{{ backupSettingsFile() method
/**
	 * Backs up the specified file in the settings directory.
	 * You should call this on any settings files your plugin
	 * writes.
	 * @param file The file
	 * @since jEdit 4.0pre1
	 */
public static void backupSettingsFile(File file) {
    if (settingsDirectory == null || !file.exists())
        return;
    String backupDir = MiscUtilities.constructPath(settingsDirectory, "settings-backup");
    File dir = new File(backupDir);
    if (!dir.exists())
        dir.mkdirs();
    // ... sweet. saveBackup() will create backupDir if it
    // doesn't exist.
    MiscUtilities.saveBackup(file, 5, null, "~", backupDir);
}