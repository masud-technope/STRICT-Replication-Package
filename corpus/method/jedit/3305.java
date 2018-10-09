//}}}
//{{{ getDockableWindowPluginClassName() method
public static String getDockableWindowPluginName(String name) {
    String pluginClass = DockableWindowFactory.getInstance().getDockableWindowPluginClass(name);
    if (pluginClass == null)
        return null;
    return jEdit.getProperty("plugin." + pluginClass + ".name");
}