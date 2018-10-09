//}}}
//{{{ createNorthPanel() method
public JPanel createNorthPanel() {
    JPanel northPanel = new JPanel(new BorderLayout());
    infoIcon = new JLabel();
    infoIcon.setIcon(UIManager.getIcon("OptionPane.informationIcon"));
    northPanel.add(BorderLayout.WEST, infoIcon);
    JPanel nameField = new JPanel();
    nameField.add(new JLabel(jEdit.getProperty("fileprop.name") + ": "));
    String filename;
    if (local instanceof FavoritesVFS.Favorite) {
        FavoritesVFS.Favorite favorite = (FavoritesVFS.Favorite) local;
        filename = favorite.getLabel();
    } else {
        filename = local.getName();
    }
    nameTextField = new JTextField(filename, 20);
    if ((local.getVFS().getCapabilities() & VFS.RENAME_CAP) == 0) {
        // If the VFS cannot rename, the nameTextField is non editable
        nameTextField.setEditable(false);
    }
    nameField.add(nameTextField);
    northPanel.add(BorderLayout.CENTER, nameField);
    northPanel.add(BorderLayout.SOUTH, new JPanel());
    return northPanel;
}