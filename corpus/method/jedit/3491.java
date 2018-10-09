//}}}
//{{{createCenterPanelAll() method
public JPanel createCenterPanelAll() {
    long filesSize = 0L;
    JPanel centerPanel = new JPanel(new BorderLayout());
    for (VFSFile selectedFile : selectedFiles) {
        if (selectedFile.getType() == VFSFile.DIRECTORY) {
            File ioFile = new File(selectedFile.getPath());
            filesSize += IOUtilities.fileLength(ioFile);
        } else if (selectedFile.getType() == VFSFile.FILE)
            filesSize += selectedFile.getLength();
    }
    JPanel propField = new JPanel();
    propField.setLayout(new GridLayout(2, 1));
    String path = local.getPath();
    if (OperatingSystem.isWindows() || OperatingSystem.isWindows9x() || OperatingSystem.isWindowsNT()) {
        // 92 = '\'
        path = path.substring(0, path.lastIndexOf(92));
    } else {
        path = path.substring(0, path.lastIndexOf('/'));
    }
    propField.add(new JLabel(jEdit.getProperty("fileprop.path") + ": " + path));
    propField.add(new JLabel(jEdit.getProperty("fileprop.size") + ": " + StandardUtilities.formatFileSize(filesSize)));
    Border etch = BorderFactory.createEtchedBorder();
    propField.setBorder(BorderFactory.createTitledBorder(etch, jEdit.getProperty("fileprop.properties")));
    centerPanel.add(BorderLayout.CENTER, propField);
    return centerPanel;
}