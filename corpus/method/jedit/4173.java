//{{{ getTableCellEditorComponent() method
public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    task = (Task) value;
    return button;
//}}}
}