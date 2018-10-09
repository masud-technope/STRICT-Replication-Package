public String getDockableWindowPluginClass(String name) {
    Window w = getDockableWindowFactory(name);
    if (w == null || w.plugin == null || w.plugin.getPlugin() == null)
        return null;
    return w.plugin.getPlugin().getClassName();
}