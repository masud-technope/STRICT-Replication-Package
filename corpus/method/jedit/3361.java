//}}}
//{{{ floatDockableWindow() method
/**
	 * Opens a new instance of the specified dockable window in a floating
	 * container.
	 * @param name The dockable window name
	 * @return The new dockable window instance
	 * @since jEdit 4.1pre2
	 */
public JComponent floatDockableWindow(String name) {
    Entry entry = windows.get(name);
    if (entry == null) {
        Log.log(Log.ERROR, this, "Unknown dockable window: " + name);
        return null;
    }
    // create a copy of this dockable window and float it
    Entry newEntry = new Entry(entry.factory, FLOATING);
    newEntry.win = newEntry.factory.createDockableWindow(view, FLOATING);
    if (newEntry.win != null) {
        FloatingWindowContainer fwc = new FloatingWindowContainer(this, true);
        newEntry.container = fwc;
        newEntry.container.register(newEntry);
        newEntry.container.show(newEntry);
    }
    clones.add(newEntry);
    return newEntry.win;
}