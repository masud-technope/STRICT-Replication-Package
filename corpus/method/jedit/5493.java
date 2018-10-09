@Override
public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    if (value == null)
        return this;
    String widget = String.valueOf(value);
    String label = jEdit.getProperty("statusbar." + widget + ".label", widget);
    setText(label);
    return this;
}