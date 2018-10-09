//}}}
//{{{ getParentDialog() method
/**
	 * Traverses the given component's parent tree looking for an
	 * instance of JDialog, and return it. If not found, return null.
	 * @param c The component
	 * @deprecated use {@link GenericGUIUtilities#getParentDialog(Component)}
	 */
public static JDialog getParentDialog(Component c) {
    return GenericGUIUtilities.getParentDialog(c);
}