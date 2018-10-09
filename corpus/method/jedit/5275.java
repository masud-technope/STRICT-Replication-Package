//{{{ remove() method
void remove(int index) {
    abbrevs.remove(index);
    fireTableStructureChanged();
//}}}
}