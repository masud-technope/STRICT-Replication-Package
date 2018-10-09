//}}}
//{{{ setEnabledRecursively() method
/**
	 * Call setEnabled() recursively on the container and its descendants.
	 * @param c The container
	 * @param enabled The enabled state to set
	 * @since jEdit 4.3pre17
	 * @deprecated use {@link GenericGUIUtilities#setEnabledRecursively(Container, boolean)}
	 */
public static void setEnabledRecursively(Container c, boolean enabled) {
    GenericGUIUtilities.setEnabledRecursively(c, enabled);
}