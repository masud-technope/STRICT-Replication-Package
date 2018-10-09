//}}}
//{{{ getDockable() method
/**
	 * Returns the specified dockable window.
	 *
	 * Note that this method
	 * will return null if the dockable has not been added yet.
	 * Make sure you call {@link #addDockableWindow(String)} first.
	 *
	 * For historical reasons, this
	 * does the same thing as {@link #getDockableWindow(String)}.
	 *
	 * @param name The name of the dockable window
	 * @since jEdit 4.0pre1
	 */
public JComponent getDockable(String name) {
    Entry entry = windows.get(name);
    if (entry == null || entry.win == null)
        return null;
    else
        return entry.win;
}