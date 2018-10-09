 RemoveButton() {
    super(jEdit.getProperty("manage-plugins.remove"));
    table.getSelectionModel().addListSelectionListener(this);
    addActionListener(this);
    setEnabled(false);
}