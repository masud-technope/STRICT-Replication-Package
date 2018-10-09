//}}}
//{{{ _save() method
protected void _save() {
    jEdit.setBooleanProperty("plugin-manager.installUser", settingsDir != null && settingsDir.isSelected());
    jEdit.setBooleanProperty("plugin-manager.downloadSource", downloadSource.isSelected());
    jEdit.setBooleanProperty("plugin-manager.deleteDownloads", deleteDownloads.isSelected());
    jEdit.setIntegerProperty("plugin-manager.list-cache.minutes", spinnerModel.getNumber().intValue());
    jEdit.setBooleanProperty("plugin-manager.disable-obsolete", disableObsolete.isSelected());
    if (miraList.getSelectedIndex() != -1) {
        String currentMirror = miraModel.getID(miraList.getSelectedIndex());
        String previousMirror = jEdit.getProperty("plugin-manager.mirror.id");
        if (!previousMirror.equals(currentMirror)) {
            jEdit.setProperty("plugin-manager.mirror.id", currentMirror);
            jEdit.setProperty("plugin-manager.mirror.name", (String) miraModel.getElementAt(miraList.getSelectedIndex()));
            updateMirrorLabel();
        // Insert code to update the plugin managers list here later
        }
    }
}