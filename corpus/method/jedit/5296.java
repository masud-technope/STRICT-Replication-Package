//}}}
//{{{ add() method
void add() {
    entries.add(new Entry("", UIManager.getColor("Tree.foreground")));
    fireTableRowsInserted(entries.size() - 1, entries.size() - 1);
}