@Override
public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    Buffer buffer = (Buffer) value;
    if (buffer == null) {
        setIcon(null);
        updateStyle(this, false, null);
    } else {
        setIcon(buffer.getIcon());
        updateStyle(this, buffer.isBackup(), buffer.getPath());
    }
    return this;
}