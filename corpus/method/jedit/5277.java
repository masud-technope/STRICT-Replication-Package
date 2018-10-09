//{{{ sort() method
void sort(int col) {
    lastSort = col;
    Collections.sort(abbrevs, new AbbrevCompare(col));
    fireTableDataChanged();
//}}}
}