//}}}
//{{{ setEnabledRecursively() method
/**
	 * Call setEnabled() recursively on the container and its descendants.
	 * @param c The container
	 * @param enabled The enabled state to set
	 * @since jEdit 5.3.1
	 */
public static void setEnabledRecursively(Container c, boolean enabled) {
    for (Component child : c.getComponents()) {
        if (child instanceof Container)
            setEnabledRecursively((Container) child, enabled);
        else
            child.setEnabled(enabled);
    }
    c.setEnabled(enabled);
}