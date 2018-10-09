public Component getListCellRendererComponent(JList<? extends Finishings> list, Finishings value, int index, boolean isSelected, boolean cellHasFocus) {
    setText(value == null ? "" : getMessage(value.toString()));
    return this;
}