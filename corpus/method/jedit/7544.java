//}}}
//{{{ getParentDialog() method
/**
	 * Traverses the given component's parent tree looking for an
	 * instance of JDialog, and return it. If not found, return null.
	 * @param c The component
	 * @since jEdit 5.3.1
	 */
public static JDialog getParentDialog(Component c) {
    return (JDialog) SwingUtilities.getAncestorOfClass(JDialog.class, c);
}