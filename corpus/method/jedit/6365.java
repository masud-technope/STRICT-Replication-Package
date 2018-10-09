//{{{ ServiceListHandler constructor
 ServiceListHandler(PluginJAR plugin, URL uri) {
    this.plugin = plugin;
    this.uri = uri;
    code = new StringBuilder();
    stateStack = new Stack<String>();
    cachedServices = new LinkedList<ServiceManager.Descriptor>();
}