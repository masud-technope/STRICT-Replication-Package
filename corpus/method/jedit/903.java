//}}}
//{{{ columnMoved() method
protected void columnMoved(int fromIndex, int toIndex) {
    if (fromIndex == toIndex)
        return;
    if (fromIndex < 1 || fromIndex > getColumnCount())
        return;
    if (toIndex < 1 || toIndex > getColumnCount())
        return;
    ExtendedAttribute ea = extAttrs.remove(fromIndex - 1);
    extAttrs.add(toIndex - 1, ea);
    if (sortColumnIndex == fromIndex)
        sortColumnIndex = toIndex;
    else if (sortColumnIndex == toIndex)
        sortColumnIndex = fromIndex;
}