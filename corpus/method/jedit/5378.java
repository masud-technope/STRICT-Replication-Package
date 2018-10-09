//}}}
//{{{ _save() method
@Override
protected void _save() {
    switch(checkModStatus.getSelectedIndex()) {
        case 0:
            jEdit.setBooleanProperty("autoReloadDialog", false);
            jEdit.setBooleanProperty("autoReload", false);
            break;
        case 1:
            jEdit.setBooleanProperty("autoReloadDialog", true);
            jEdit.setBooleanProperty("autoReload", false);
            break;
        case 2:
            jEdit.setBooleanProperty("autoReloadDialog", true);
            jEdit.setBooleanProperty("autoReload", true);
            break;
        case 3:
            jEdit.setBooleanProperty("autoReloadDialog", false);
            jEdit.setBooleanProperty("autoReload", true);
            break;
    }
    jEdit.setIntegerProperty("checkFileStatus", checkModStatusUpon.getSelectedIndex());
    jEdit.setIntegerProperty("recentFiles", (Integer) recentFiles.getModel().getValue());
    jEdit.setBooleanProperty("sortRecent", sortRecent.isSelected());
    jEdit.setBooleanProperty("hideOpen", hideOpen.isSelected());
    jEdit.setBooleanProperty("closeAllConfirm", closeAllConfirm.isSelected());
    jEdit.setBooleanProperty("saveCaret", saveCaret.isSelected());
    jEdit.setBooleanProperty("persistentMarkers", persistentMarkers.isSelected());
    jEdit.setBooleanProperty("restore", restore.isSelected());
    jEdit.setBooleanProperty("restore.cli", restoreCLI.isSelected());
    jEdit.setBooleanProperty("restore.remote", restoreRemote.isSelected());
    jEdit.setBooleanProperty("restore.splits", restoreSplits.isSelected());
    {
        int maxWarnResults = (Integer) hypersearchResultsWarning.getModel().getValue();
        jEdit.setIntegerProperty("hypersearch.maxWarningResults", maxWarnResults);
    }
    jEdit.setBooleanProperty("lang.usedefaultlocale", useDefaultLocale.isSelected());
    jEdit.setProperty("lang.current", String.valueOf(lang.getSelectedItem()));
}