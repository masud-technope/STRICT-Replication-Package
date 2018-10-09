//}}}
//{{{ createCenterPanel() method
public JPanel createCenterPanel() {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm");
    JPanel centerPanel = new JPanel(new BorderLayout());
    JPanel propField = new JPanel();
    propField.setLayout(new GridLayout(4, 1));
    propField.add(new JLabel(jEdit.getProperty("fileprop.name") + ": " + local.getName()));
    propField.add(new JLabel(jEdit.getProperty("fileprop.path") + ": " + local.getPath()));
    // Show last modified property only for LocalFile
    if (local instanceof LocalFile) {
        propField.add(new JLabel(jEdit.getProperty("fileprop.lastmod") + ": " + sdf.format(new Date(((LocalFile) local).getModified()))));
    }
    if (local.getType() == VFSFile.DIRECTORY) {
        File ioFile = new File(local.getPath());
        propField.add(new JLabel(jEdit.getProperty("fileprop.size") + ": " + StandardUtilities.formatFileSize(IOUtilities.fileLength(ioFile))));
    } else {
        propField.add(new JLabel(jEdit.getProperty("fileprop.size") + ": " + StandardUtilities.formatFileSize(local.getLength())));
    }
    Border etch = BorderFactory.createEtchedBorder();
    propField.setBorder(BorderFactory.createTitledBorder(etch, jEdit.getProperty("fileprop.properties")));
    centerPanel.add(BorderLayout.CENTER, propField);
    JPanel attributeField = new JPanel();
    attributeField.setLayout(new GridLayout(1, 2));
    readable = new JCheckBox(jEdit.getProperty("fileprop.readable"));
    readable.setSelected(local.isReadable());
    readable.setEnabled(false);
    attributeField.add(readable);
    write = new JCheckBox(jEdit.getProperty("fileprop.writeable"));
    write.setSelected(local.isWriteable());
    write.setEnabled(false);
    attributeField.add(write);
    attributeField.setBorder(BorderFactory.createTitledBorder(etch, jEdit.getProperty("fileprop.attribute")));
    centerPanel.add(BorderLayout.SOUTH, attributeField);
    return centerPanel;
}