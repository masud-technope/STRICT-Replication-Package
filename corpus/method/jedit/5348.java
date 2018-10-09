//{{{ showSet() method
public void showSet(String set) {
    windows = dockableSets.get(set);
    Collections.sort(windows, new WindowCompare());
    fireTableDataChanged();
}