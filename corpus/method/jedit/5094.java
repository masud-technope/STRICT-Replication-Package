//}}}
//{{{ isBackup() method
/**
	 * Check if the filename is a backup file.
	 * @param filename the filename to check
	 * @return true if this is a backup file.
	 * @since jEdit 4.3pre5
	 */
public static boolean isBackup(String filename) {
    if (filename == null) {
        return false;
    }
    // check for Untitled-XX
    if (filename.matches("Untitled-\\d+")) {
        return false;
    }
    // check for #Untitled-X# and #filename#save#
    if (filename.matches("[#]Untitled-\\d+[#]") || filename.matches("[#].*?[#]save[#]")) {
        return true;
    }
    // check for user supplied prefix and suffix
    String backupPrefix = jEdit.getProperty("backup.prefix");
    String backupSuffix = jEdit.getProperty("backup.suffix");
    if (backupPrefix != null && !backupPrefix.isEmpty() && backupSuffix != null && !backupSuffix.isEmpty()) {
        return filename.startsWith(backupPrefix) && filename.endsWith(backupSuffix);
    }
    if (backupPrefix != null && !backupPrefix.isEmpty() && filename.startsWith(backupPrefix)) {
        return true;
    }
    if (backupSuffix != null && !backupSuffix.isEmpty() && filename.endsWith(backupSuffix)) {
        return true;
    }
    // if the user sets an empty prefix and suffix, then check if the filename ends with a number
    if ((backupPrefix == null || backupPrefix.isEmpty() || backupSuffix == null || backupSuffix.isEmpty()) && filename.matches(".*?\\d+")) {
        return true;
    }
    return false;
}