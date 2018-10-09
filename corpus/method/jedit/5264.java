//{{{ setValueAt() method
@Override
public void setValueAt(Object value, int row, int col) {
    if (value == null)
        value = "";
    Abbrev abbrev = abbrevs.get(row);
    if (col == 0)
        abbrev.abbrev = (String) value;
    else
        abbrev.expand = (String) value;
    fireTableRowsUpdated(row, row);
//}}}
}