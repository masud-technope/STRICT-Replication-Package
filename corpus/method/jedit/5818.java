//{{{ PluginManager constructor
private  PluginManager(Frame parent) {
    super(jEdit.getProperty("plugin-manager.title"));
    this.parent = parent;
    init();
}