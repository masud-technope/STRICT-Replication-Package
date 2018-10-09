// }}}
// {{{ public methods
// {{{ init()
public void init() {
    EditBus.addToBus(this);
    Iterator<DockableWindowFactory.Window> entries = factory.getDockableWindowIterator();
    while (entries.hasNext()) {
        DockableWindowFactory.Window window = entries.next();
        String dockable = window.name;
        positions.put(dockable, getDockablePosition(dockable));
        addPluginDockable(window.plugin, dockable);
    }
}