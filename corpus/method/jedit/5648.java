//}}}
//{{{ update() method
public void update() {
    Set<String> savedChecked = new HashSet<String>();
    Set<String> savedSelection = new HashSet<String>();
    saveSelection(savedChecked, savedSelection);
    PluginList pluginList = window.getPluginList();
    if (pluginList == null)
        return;
    entries.clear();
    for (PluginList.PluginSet set : pluginList.pluginSets) {
        for (int j = 0; j < set.plugins.size(); j++) {
            PluginList.Plugin plugin = pluginList.pluginHash.get(set.plugins.get(j));
            PluginList.Branch branch = plugin.getCompatibleBranch();
            String installedVersion = plugin.getInstalledVersion();
            if (updates) {
                if (branch != null && branch.canSatisfyDependencies() && installedVersion != null && StandardUtilities.compareStrings(branch.version, installedVersion, false) > 0) {
                    entries.add(new Entry(plugin, set.name));
                }
            } else {
                if (plugin.canBeInstalled())
                    entries.add(new Entry(plugin, set.name));
            }
        }
    }
    sort(sortType);
    restoreSelection(savedChecked, savedSelection);
//}}}
}