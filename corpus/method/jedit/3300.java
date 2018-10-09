//}}}
//{{{ getDockableWindow() method
/**
	 * Returns the specified dockable window.
	 *
	 * Note that this method
	 * will return null if the dockable has not been added yet.
	 * Make sure you call {@link #addDockableWindow(String)} first.
	 *
	 * @param name The name of the dockable window
	 * @since jEdit 4.1pre2
	 */
public JComponent getDockableWindow(String name) {
    return getDockable(name);
}