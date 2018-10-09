//}}}
//{{{ getBackupDirectory method
/**
	 * Get backup.directory property, or null.
	 * @return backup.directory property, or null
	 * @since jEdit 5.5pre1
	 */
public static String getBackupDirectory() {
    String backupDirectory = jEdit.getProperty("backup.directory");
    if (backupDirectory == null || backupDirectory.length() == 0) {
        return null;
    } else {
        return MiscUtilities.expandVariables(backupDirectory);
    }
}