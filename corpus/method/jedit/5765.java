//}}}
//{{{ finished() method
void finished() {
    // in dependencies
    for (Plugin plugin : plugins) {
        for (int j = 0; j < plugin.branches.size(); j++) {
            Branch branch = plugin.branches.get(j);
            for (int k = 0; k < branch.deps.size(); k++) {
                Dependency dep = branch.deps.get(k);
                if (dep.what.equals("plugin"))
                    dep.plugin = pluginHash.get(dep.pluginName);
            }
        }
    }
}