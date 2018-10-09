//}}}
//{{{ loadPluginProps() method
Properties loadPluginProps(InputStream in) throws IOException {
    Properties plugin = new Properties();
    loadProps(plugin, in);
    plugins.add(plugin);
    return plugin;
}