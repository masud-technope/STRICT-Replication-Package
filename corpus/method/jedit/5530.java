public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    IconListEntry icon = (IconListEntry) value;
    setIcon(icon.icon);
    return this;
}