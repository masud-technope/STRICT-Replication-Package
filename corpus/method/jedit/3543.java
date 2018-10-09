//}}}
//{{{ getValueAt() method
@Override
public Object getValueAt(int rowIndex, int columnIndex) {
    int trueRowIndex = getTrueRow(rowIndex);
    return delegated.getValueAt(trueRowIndex, columnIndex);
}