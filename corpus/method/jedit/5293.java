//}}}
//{{{ moveDown() method
public void moveDown(int index) {
    Entry entry = entries.get(index);
    entries.remove(index);
    entries.add(index + 1, entry);
    fireTableRowsUpdated(index, index + 1);
}