//}}}
//{{{ Private members
//{{{ makeBackup() method
/**
	 * Make the backup.
	 */
private void makeBackup() {
    try {
        // Only backup once per session
        if (buffer.getProperty(Buffer.BACKED_UP) == null || jEdit.getBooleanProperty("backupEverySave")) {
            if (jEdit.getIntegerProperty("backups", 1) > 0)
                vfs._backup(session, path, view);
            buffer.setBooleanProperty(Buffer.BACKED_UP, true);
        }
    } catch (IOException ioe) {
        String[] pp = { ioe.getMessage() };
        VFSManager.error(view, path, "ioerror.backup-failed", pp);
    }
}