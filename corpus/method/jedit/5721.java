 SaveButton() {
    setIcon(GUIUtilities.loadIcon(jEdit.getProperty("manage-plugins.save.icon")));
    setToolTipText("Save Currently Checked Plugins Set");
    addActionListener(this);
    setEnabled(true);
}