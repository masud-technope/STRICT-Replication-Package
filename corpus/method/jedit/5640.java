 SelectallButton() {
    super(jEdit.getProperty("install-plugins.select-all"));
    addActionListener(this);
    pluginModel.addTableModelListener(this);
// setEnabled(false);
}