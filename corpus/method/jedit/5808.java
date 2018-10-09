//}}}
//{{{ showPluginManager() method
public static void showPluginManager(Frame parent) {
    if (instance == null)
        instance = new PluginManager(parent);
    instance.toFront();
}