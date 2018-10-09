//{{{ getTableCellRendererComponent() method
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean cellHasFocus, int row, int col) {
    if (isSelected) {
        setBackground(table.getSelectionBackground());
        setForeground(table.getSelectionForeground());
    } else {
        setBackground(table.getBackground());
        setForeground(table.getForeground());
    }
    if (value != null)
        setBackground((Color) value);
    setBorder(cellHasFocus ? UIManager.getBorder("Table.focusCellHighlightBorder") : SyntaxHiliteOptionPane.noFocusBorder);
    return this;
//}}}
}