public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    Font f = (Font) value;
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    setText(f.getFamily() + " " + f.getSize());
    return this;
}