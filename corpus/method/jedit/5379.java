@Override
public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    String label = jEdit.getProperty("options.appearance.lang." + value);
    if (label != null)
        setText(label);
    return this;
}