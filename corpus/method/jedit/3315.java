// }}}
// {{{ handlePluginUpdate() method
@EBHandler
public void handlePluginUpdate(PluginUpdate pmsg) {
    if (pmsg.getWhat() == PluginUpdate.LOADED) {
        Iterator<DockableWindowFactory.Window> iter = factory.getDockableWindowIterator();
        while (iter.hasNext()) {
            DockableWindowFactory.Window w = iter.next();
            if (w.plugin == pmsg.getPluginJAR()) {
                String position = getDockablePosition(w.name);
                positions.put(w.name, position);
                addPluginDockable(w.plugin, w.name);
                dockableLoaded(w.name, position);
            }
        }
        propertiesChanged();
    } else if (pmsg.isExiting()) {
    // we don't care
    } else if (pmsg.getWhat() == PluginUpdate.DEACTIVATED || pmsg.getWhat() == PluginUpdate.UNLOADED) {
        Set<String> dockables = plugins.remove(pmsg.getPluginJAR());
        if (dockables != null) {
            for (String dockable : dockables) {
                disposeDockableWindow(dockable);
                windows.remove(dockable);
            }
        }
    }
}