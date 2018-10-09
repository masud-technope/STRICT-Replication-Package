public Component getListCellRendererComponent(JList<? extends OrientationRequested> list, OrientationRequested value, int index, boolean isSelected, boolean cellHasFocus) {
    setText(value == null ? "" : getMessage(value.toString()));
    return this;
}