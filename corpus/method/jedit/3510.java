//}}}
//{{{ getElementAt() method
public Object getElementAt(int index) {
    int trueRowIndex = getTrueRow(index);
    return delegated.getElementAt(trueRowIndex);
}