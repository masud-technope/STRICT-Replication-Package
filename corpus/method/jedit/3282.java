//}}}
//{{{ addDockableWindow() method
/**
	 * Opens the specified dockable window. As of jEdit 4.0pre1, has the
	 * same effect as calling showDockableWindow().
	 * @param name The dockable window name
	 * @since jEdit 2.6pre3
	 */
public void addDockableWindow(String name) {
    showDockableWindow(name);
}