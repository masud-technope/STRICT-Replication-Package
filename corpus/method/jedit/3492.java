//}}}
//{{{createNorthPanelAll() method
public JPanel createNorthPanelAll() {
    JPanel northPanel = new JPanel(new BorderLayout());
    infoIcon = new JLabel();
    infoIcon.setIcon(UIManager.getIcon("OptionPane.informationIcon"));
    northPanel.add(BorderLayout.WEST, infoIcon);
    int filesCounter = 0;
    int directoriesCounter = 0;
    for (VFSFile selectedFile : selectedFiles) {
        if (selectedFile.getType() == VFSFile.DIRECTORY)
            directoriesCounter++;
        else if (selectedFile.getType() == VFSFile.FILE)
            filesCounter++;
    }
    JPanel nameField = new JPanel();
    nameField.add(new JLabel(jEdit.getProperty("fileprop.selectedFiles") + ": " + filesCounter + ", " + jEdit.getProperty("fileprop.selectedDirectories") + ": " + directoriesCounter));
    northPanel.add(BorderLayout.CENTER, nameField);
    northPanel.add(BorderLayout.SOUTH, new JPanel());
    return northPanel;
}