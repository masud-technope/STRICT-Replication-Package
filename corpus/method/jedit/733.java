//}}}
//{{{ saveExpansionState() method
public void saveExpansionState() {
    tmpExpanded.clear();
    table.getExpandedDirectories(tmpExpanded);
}