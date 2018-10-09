//}}}
//{{{ getRowCount() method
@Override
public int getRowCount() {
    if (filteredIndices == null)
        return delegated.getRowCount();
    return filteredIndices.size();
}