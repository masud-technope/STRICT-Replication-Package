@Override
public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    ParentDirectoryRenderer.this.setBorder(new EmptyBorder(1, index * 5 + 1, 1, 1));
    if (value instanceof LoadingPlaceholder) {
        ParentDirectoryRenderer.this.setFont(plainFont);
        setIcon(showIcons ? FileCellRenderer.loadingIcon : null);
        setText(jEdit.getProperty("vfs.browser.tree.loading"));
    } else if (value instanceof VFSFile) {
        VFSFile dirEntry = (VFSFile) value;
        ParentDirectoryRenderer.this.setFont(boldFont);
        setIcon(showIcons ? FileCellRenderer.getIconForFile(dirEntry, true) : null);
        setText(dirEntry.getName());
    } else if (value == null)
        setText("VFS does not follow VFS API");
    return this;
}