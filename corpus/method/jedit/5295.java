//}}}
//{{{ remove() method
void remove(int index) {
    entries.remove(index);
    fireTableRowsDeleted(entries.size(), entries.size());
}