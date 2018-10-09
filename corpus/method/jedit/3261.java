//}}}
//{{{ registerDockableWindow() method
public void registerDockableWindow(PluginJAR plugin, String name, String code, boolean actions, boolean movable) {
    Window factory = dockableWindowFactories.get(name);
    if (factory != null) {
        factory.code = code;
        factory.loaded = true;
    } else {
        factory = new Window(plugin, name, code, actions, movable);
        dockableWindowFactories.put(name, factory);
    }
}