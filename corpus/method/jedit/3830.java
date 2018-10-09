//}}}
//{{{ getCurrent() method
/**
	 * Returns the name of the dockable in this container.
	 * @since jEdit 4.2pre1
	 */
public String getCurrent() {
    if (current == null)
        return null;
    else
        return current.factory.name;
}