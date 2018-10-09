//}}}
//{{{ hideDockableWindow() method
/**
	 * Hides the specified dockable window.
	 * @param name The dockable window name
	 * @since jEdit 2.6pre3
	 */
public void hideDockableWindow(String name) {
    Entry entry = windows.get(name);
    if (entry == null) {
        Log.log(Log.ERROR, this, "Unknown dockable window: " + name);
        return;
    }
    if (entry.win == null)
        return;
    entry.container.show(null);
}