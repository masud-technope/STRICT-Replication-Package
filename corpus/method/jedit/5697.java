@Override
public void actionPerformed(ActionEvent evt) {
    jEdit.setBooleanProperty("plugin-manager.hide-libraries.toggle", isSelected());
    ManagePanel.this.update();
}