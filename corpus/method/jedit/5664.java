//{{{ actionPerformed() method
@Override
public void actionPerformed(ActionEvent ae) {
    path = jEdit.getProperty(PluginManager.PROPERTY_PLUGINSET, jEdit.getSettingsDirectory() + File.separator);
    String[] selectedFiles = GUIUtilities.showVFSFileDialog(InstallPanel.this.window, jEdit.getActiveView(), path, VFSBrowser.OPEN_DIALOG, false);
    if (selectedFiles == null || selectedFiles.length != 1)
        return;
    path = selectedFiles[0];
    boolean success = loadPluginSet(path);
    if (success) {
        jEdit.setProperty(PluginManager.PROPERTY_PLUGINSET, path);
    }
    updateUI();
//}}}
}