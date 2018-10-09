public Component getListCellRendererComponent(JList<? extends Mode> list, Mode value, int index, boolean isSelected, boolean cellHasFocus) {
    String s = value.toString();
    setText(s);
    setForeground(value.isUserMode() ? Color.GREEN : isSelected ? list.getSelectionForeground() : list.getForeground());
    setBackground(isSelected ? list.getSelectionBackground() : list.getBackground());
    setOpaque(true);
    return this;
}