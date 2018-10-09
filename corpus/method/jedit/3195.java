@Override
public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
    return candidates.getCellRenderer(list, index, isSelected, cellHasFocus);
}