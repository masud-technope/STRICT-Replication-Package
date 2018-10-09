public Component getListCellRendererComponent(JList<? extends Sides> list, Sides value, int index, boolean isSelected, boolean cellHasFocus) {
    setText(value == null ? "" : getMessage(value.toString()));
    return this;
}