//{{{ updateDeps() method
/***
		 * recursively add dependencies to install,
		 * or remove entry from its dependencies' dependents list
		 * @param entry	entry whose install field has been set
		 */
private void updateDeps(Entry entry) {
    List<PluginList.Dependency> deps = entry.plugin.getCompatibleBranch().deps;
    for (PluginList.Dependency dep : deps) {
        if ("plugin".equals(dep.what)) {
            for (Entry temp : entries) {
                if (temp.plugin == dep.plugin) {
                    if (entry.install) {
                        temp.dependents.add(entry);
                        if (!temp.install) {
                            if (temp.installedVersion == null) {
                                temp.install = true;
                            } else if (!temp.plugin.loaded) {
                                temp.install = true;
                            }
                            updateDeps(temp);
                        }
                    } else {
                        temp.dependents.remove(entry);
                    }
                    break;
                }
            }
        }
    }
//}}}
}