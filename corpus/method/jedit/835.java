@Override
public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    assert value instanceof VFSFileFilter : "Filter is not a VFSFileFilter";
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    setText(((VFSFileFilter) value).getDescription());
    return this;
}