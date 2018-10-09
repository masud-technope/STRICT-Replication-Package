// }}}
// {{{ addPluginDockable
private void addPluginDockable(PluginJAR plugin, String name) {
    Set<String> dockables = plugins.get(plugin);
    if (dockables == null) {
        dockables = new HashSet<String>();
        plugins.put(plugin, dockables);
    }
    dockables.add(name);
}