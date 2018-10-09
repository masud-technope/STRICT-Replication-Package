//}}}
//{{{ isCellEditable() method
@Override
public boolean isCellEditable(int rowIndex, int columnIndex) {
    int trueRowIndex = getTrueRow(rowIndex);
    return delegated.isCellEditable(trueRowIndex, columnIndex);
}