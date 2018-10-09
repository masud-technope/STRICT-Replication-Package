//}}}
//{{{ init() method
/**
	 * Initialises dockable window manager. Do not call this method directly.
	 */
public void init() {
    super.init();
    Iterator<DockableWindowFactory.Window> entries = factory.getDockableWindowIterator();
    while (entries.hasNext()) addEntry(entries.next());
    propertiesChanged();
}