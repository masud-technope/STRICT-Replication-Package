//}}}
//{{{ _save() method
@Override
protected void _save() {
    jEdit.setBooleanProperty("saveAsUsesFSB", saveAsUsesFSB.isSelected());
    jEdit.setBooleanProperty("twoStageSave", twoStageSave.isSelected());
    jEdit.setBooleanProperty("confirmSaveAll", confirmSaveAll.isSelected());
    jEdit.setProperty("autosave", this.autosave.getText());
    jEdit.setProperty("backups", backups.getText());
    jEdit.setProperty("backup.directory", backupDirectory.getText());
    String autosaveDirectoryOriginal = jEdit.getProperty("autosave.directory");
    jEdit.setProperty("autosave.directory", autosaveDirectory.getText());
    jEdit.setProperty("backup.prefix", backupPrefix.getText());
    jEdit.setProperty("backup.suffix", backupSuffix.getText());
    jEdit.setBooleanProperty("backupEverySave", backupEverySave.isSelected());
    boolean newAutosave = autosaveUntitled.isSelected();
    boolean oldAutosave = jEdit.getBooleanProperty("autosaveUntitled");
    jEdit.setBooleanProperty("autosaveUntitled", newAutosave);
    jEdit.setBooleanProperty("suppressNotSavedConfirmUntitled", suppressNotSavedConfirmUntitled.isSelected());
    jEdit.setBooleanProperty("useMD5forDirtyCalculation", useMD5forDirtyCalculation.isSelected());
    if ((!newAutosave || jEdit.getIntegerProperty("autosave", 0) == 0) && oldAutosave) {
        Buffer[] buffers = jEdit.getBuffers();
        for (Buffer buffer : buffers) {
            if (buffer.isUntitled()) {
                buffer.removeAutosaveFile();
            }
        }
    }
    // to have the autosaves at the new location
    if (!autosaveDirectoryOriginal.equals(autosaveDirectory.getText())) {
        Buffer[] buffers = jEdit.getBuffers();
        for (Buffer buffer : buffers) {
            // save dirty
            if (buffer.isDirty()) {
                buffer.autosave(true);
            }
        }
    }
}