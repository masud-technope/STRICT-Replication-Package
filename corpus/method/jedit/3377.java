//}}}
//{{{ handlePluginUpdate() method
@EBHandler
public void handlePluginUpdate(PluginUpdate pmsg) {
    if (pmsg.getWhat() == PluginUpdate.LOADED) {
        Iterator<DockableWindowFactory.Window> iter = factory.getDockableWindowIterator();
        while (iter.hasNext()) {
            DockableWindowFactory.Window w = iter.next();
            if (w.plugin == pmsg.getPluginJAR())
                addEntry(w);
        }
        propertiesChanged();
    } else if (pmsg.isExiting()) {
    // we don't care
    } else if (pmsg.getWhat() == PluginUpdate.DEACTIVATED) {
        Iterator<Entry> iter = getAllPluginEntries(pmsg.getPluginJAR(), false);
        while (iter.hasNext()) {
            Entry entry = iter.next();
            if (entry.container != null)
                entry.container.remove(entry);
        }
    } else if (pmsg.getWhat() == PluginUpdate.UNLOADED) {
        Iterator<Entry> iter = getAllPluginEntries(pmsg.getPluginJAR(), true);
        while (iter.hasNext()) {
            Entry entry = iter.next();
            if (entry.container != null) {
                entry.container.unregister(entry);
                entry.win = null;
                entry.container = null;
            }
        }
    }
}