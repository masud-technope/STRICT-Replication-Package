 HelpButton() {
    super(jEdit.getProperty("manage-plugins.help"));
    table.getSelectionModel().addListSelectionListener(this);
    addActionListener(this);
    setEnabled(false);
}