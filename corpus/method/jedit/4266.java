//}}}
//{{{ isAncestorOf() method
/**
	 * Returns if the first component is an ancestor of the
	 * second by traversing up the component hierarchy.
	 *
	 * @param comp1 The ancestor
	 * @param comp2 The component to check
	 * @since jEdit 4.1pre5
	 * @deprecated use {@link GenericGUIUtilities#isAncestorOf(Component, Component)}
	 */
public static boolean isAncestorOf(Component comp1, Component comp2) {
    return GenericGUIUtilities.isAncestorOf(comp1, comp2);
}