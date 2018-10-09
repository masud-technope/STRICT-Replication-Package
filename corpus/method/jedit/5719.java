@Override
public void actionPerformed(ActionEvent e) {
    String path = jEdit.getProperty("plugin-manager.pluginset.path", jEdit.getSettingsDirectory() + File.separator);
    VFSFileChooserDialog fileChooser = new VFSFileChooserDialog(ManagePanel.this.window, jEdit.getActiveView(), path, VFSBrowser.SAVE_DIALOG, false, true);
    String[] fileselections = fileChooser.getSelectedFiles();
    List<Entry> pluginSelections = new ArrayList<Entry>();
    if (fileselections == null || fileselections.length != 1)
        return;
    PluginJAR[] jars = jEdit.getPluginJARs();
    for (PluginJAR jar : jars) {
        if (jar.getPlugin() != null) {
            Entry entry = new Entry(jar);
            pluginSelections.add(entry);
        }
    }
    saveState(fileselections[0], pluginSelections);
    jEdit.setProperty("plugin-manager.pluginset.path", fileselections[0]);
    EditBus.send(new PropertiesChanged(PluginManager.getInstance()));
}