 RestoreButton() {
    setIcon(GUIUtilities.loadIcon(jEdit.getProperty("manage-plugins.restore.icon")));
    addActionListener(this);
    setToolTipText("Choose a PluginSet, select/deselect plugins based on set.");
}