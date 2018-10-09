//}}}
//{{{ saveSettings() method
/**
	 * Saves all user preferences to disk.
	 */
public static void saveSettings() {
    if (settingsDirectory == null)
        return;
    Abbrevs.save();
    keymapManager.getKeymap().save();
    FavoritesVFS.saveFavorites();
    HistoryModel.saveHistory();
    Registers.saveRegisters();
    SearchAndReplace.save();
    BufferHistory.save();
    KillRing.getInstance().save();
    File file1 = new File(MiscUtilities.constructPath(settingsDirectory, "#properties#save#"));
    File file2 = new File(MiscUtilities.constructPath(settingsDirectory, "properties"));
    if (file2.exists() && file2.lastModified() != propsModTime) {
        Log.log(Log.WARNING, jEdit.class, file2 + " changed" + " on disk; will not save user properties");
    } else {
        backupSettingsFile(file2);
        OutputStream out = null;
        try {
            out = new FileOutputStream(file1);
            propMgr.saveUserProps(out);
        } catch (IOException io) {
            Log.log(Log.ERROR, jEdit.class, io);
        } finally {
            IOUtilities.closeQuietly((Closeable) out);
        }
        file2.delete();
        if (!file1.renameTo(file2)) {
            Log.log(Log.ERROR, jEdit.class, "Failed to rename \"" + file1 + "\" to the user properties file \"" + file2 + "\".");
        }
        propsModTime = file2.lastModified();
    }
}