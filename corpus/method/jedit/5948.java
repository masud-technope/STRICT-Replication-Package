public Component getListCellRendererComponent(JList<? extends PrintService> list, PrintService value, int index, boolean isSelected, boolean cellHasFocus) {
    setText(value == null ? "" : value.getName());
    Color background;
    Color foreground;
    if (isSelected) {
        background = jEdit.getColorProperty("view.selectionColor");
        foreground = jEdit.getColorProperty("view.fgColor");
    } else {
        background = jEdit.getColorProperty("view.bgColor");
        foreground = jEdit.getColorProperty("view.fgColor");
    }
    setBackground(background);
    setForeground(foreground);
    Dimension d = new Dimension((int) getSize().getWidth(), (int) getSize().getHeight() + 5);
    setSize(d);
    return this;
}