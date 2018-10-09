//}}}
//{{{ moveUp() method
public void moveUp(int index) {
    Entry entry = entries.get(index);
    entries.remove(index);
    entries.add(index - 1, entry);
    fireTableRowsUpdated(index - 1, index);
}