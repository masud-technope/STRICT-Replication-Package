//}}}
//{{{ removeDockableWindow() method
/**
	 * Hides the specified dockable window. As of jEdit 4.2pre1, has the
	 * same effect as calling hideDockableWindow().
	 * @param name The dockable window name
	 * @since jEdit 4.2pre1
	 */
public void removeDockableWindow(String name) {
    hideDockableWindow(name);
}