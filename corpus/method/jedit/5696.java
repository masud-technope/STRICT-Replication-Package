 HideLibrariesButton() {
    super(jEdit.getProperty("plugin-manager.hide-libraries"));
    setSelected(jEdit.getBooleanProperty("plugin-manager.hide-libraries.toggle"));
    addActionListener(this);
}