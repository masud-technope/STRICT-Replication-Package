//}}}
//{{{ isDockableWindowVisible() method
/**
	 * Returns if the specified dockable window is visible.
	 * @param name The dockable window name
	 */
public boolean isDockableWindowVisible(String name) {
    Entry entry = windows.get(name);
    if (entry == null || entry.win == null)
        return false;
    else
        return entry.container.isVisible(entry);
}