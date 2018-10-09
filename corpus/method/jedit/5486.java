@Override
public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    String label = jEdit.getProperty("keymaps." + value + ".label", String.valueOf(value).replace('_', ' '));
    setText(label);
    return this;
}