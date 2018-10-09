//}}}
//{{{ setValueAt() method
@Override
public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    int trueRowIndex = getTrueRow(rowIndex);
    delegated.setValueAt(aValue, trueRowIndex, columnIndex);
}