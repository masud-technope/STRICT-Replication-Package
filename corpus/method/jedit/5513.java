//{{{ setValueAt() method
@Override
public void setValueAt(Object value, int row, int col) {
    StyleChoice ch = styleChoices.get(row);
    if (col == 1)
        ch.style = (SyntaxStyle) value;
    fireTableRowsUpdated(row, row);
//}}}
}