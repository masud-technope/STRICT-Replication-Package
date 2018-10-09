//{{{ WindowTableModel constructor
 WindowTableModel() {
    dockableSets = new HashMap<String, List<Entry>>();
    List<Entry> all = new ArrayList<Entry>();
    dockableSets.put(ALL_DOCKABLE_SET, all);
    windows = new ArrayList<Entry>();
    String[] dockables = DockableWindowManager.getRegisteredDockableWindows();
    for (String dockable : dockables) {
        String plugin = DockableWindowManager.getDockableWindowPluginName(dockable);
        String set;
        if (plugin != null)
            set = PLUGIN_SET_PREFIX + plugin;
        else
            set = CORE_DOCKABLE_SET;
        List<Entry> currentSetDockables = dockableSets.get(set);
        if (currentSetDockables == null) {
            currentSetDockables = new ArrayList<Entry>();
            dockableSets.put(set, currentSetDockables);
        }
        Entry entry = new Entry(dockable);
        currentSetDockables.add(entry);
        all.add(entry);
    }
    showSet(ALL_DOCKABLE_SET);
}