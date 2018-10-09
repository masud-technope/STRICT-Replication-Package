//}}}
//{{{ isDockableWindowDocked() method
/**
	 * Returns if the specified dockable window is docked into the
	 * view.
	 * @param name The dockable's name
	 * @since jEdit 4.0pre2
	 */
public boolean isDockableWindowDocked(String name) {
    Entry entry = windows.get(name);
    if (entry == null)
        return false;
    else
        return !entry.position.equals(FLOATING);
}