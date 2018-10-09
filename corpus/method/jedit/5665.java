 InstallButton() {
    super(jEdit.getProperty("install-plugins.install"));
    pluginModel.addTableModelListener(this);
    addActionListener(this);
    setEnabled(false);
}