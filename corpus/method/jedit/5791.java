//{{{ PluginListHandler constructor
 PluginListHandler(PluginList pluginList, String path) {
    this.pluginList = pluginList;
    this.path = path;
    author = new StringBuilder();
    description = new StringBuilder();
    pluginSetEntry = new StringBuilder();
    download = new StringBuilder();
    downloadSource = new StringBuilder();
}