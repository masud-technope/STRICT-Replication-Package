//}}}
//{{{ getDockables() method
public String[] getDockables() {
    String[] retVal = new String[dockables.size()];
    for (int i = 0; i < dockables.size(); i++) {
        DockableWindowManagerImpl.Entry entry = dockables.get(i);
        retVal[i] = entry.factory.name;
    }
    return retVal;
}