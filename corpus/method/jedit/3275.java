//{{{ load() method
void load() {
    if (loaded)
        return;
    loadDockableWindows(plugin, plugin.getDockablesURI(), null);
//}}}
}