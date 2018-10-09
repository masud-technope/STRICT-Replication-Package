public Component getListCellRendererComponent(JList<? extends Chromaticity> list, Chromaticity value, int index, boolean isSelected, boolean cellHasFocus) {
    setText(value == null ? "" : getMessage(value.toString()));
    return this;
}