//}}}
//{{{ sortByColumn() method
public boolean sortByColumn(int columnIndex) {
    // toggle ascending/descending if column was clicked again
    ascending = sortColumnIndex != columnIndex || !ascending;
    // we don't sort by some attributes
    String sortBy = getSortAttribute(columnIndex);
    if (sortBy == VFS.EA_STATUS)
        return false;
    Arrays.sort(files, new EntryCompare(sortBy, ascending));
    // remember column
    sortColumnIndex = columnIndex;
    fireTableStructureChanged();
    return true;
}