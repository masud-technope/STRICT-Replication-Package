//{{{ addPlugin() method
void addPlugin(Plugin plugin) {
    plugins.add(plugin);
    pluginHash.put(plugin.name, plugin);
}