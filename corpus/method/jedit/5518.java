//{{{ getTableCellRendererComponent() method
public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean cellHasFocus, int row, int col) {
    if (value != null) {
        SyntaxStyle style = (SyntaxStyle) value;
        setForeground(style.getForegroundColor());
        if (style.getBackgroundColor() != null)
            setBackground(style.getBackgroundColor());
        else {
            // this part sucks
            setBackground(jEdit.getColorProperty("view.bgColor"));
        }
        setFont(style.getFont());
    }
    setBorder(cellHasFocus ? UIManager.getBorder("Table.focusCellHighlightBorder") : SyntaxHiliteOptionPane.noFocusBorder);
    return this;
//}}}
}