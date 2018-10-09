//}}}
//{{{ isAncestorOf() method
/**
	 * Returns if the first component is an ancestor of the
	 * second by traversing up the component hierarchy.
	 *
	 * @param comp1 The ancestor
	 * @param comp2 The component to check
	 * @since jEdit 5.3.1
	 */
public static boolean isAncestorOf(Component comp1, Component comp2) {
    while (comp2 != null) {
        if (comp1 == comp2)
            return true;
        else
            comp2 = comp2.getParent();
    }
    return false;
}