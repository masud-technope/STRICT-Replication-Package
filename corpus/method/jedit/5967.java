public Component getListCellRendererComponent(JList<? extends PrintQuality> list, PrintQuality value, int index, boolean isSelected, boolean cellHasFocus) {
    setText(value == null ? "" : getMessage(value.toString()));
    return this;
}