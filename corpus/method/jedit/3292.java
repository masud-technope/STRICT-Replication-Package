//}}}
//{{{ toggleDockableWindow() method
/**
	 * Toggles the visibility of the specified dockable window.
	 * @param name The dockable window name
	 */
public void toggleDockableWindow(String name) {
    if (isDockableWindowVisible(name))
        removeDockableWindow(name);
    else
        addDockableWindow(name);
}