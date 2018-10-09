//}}}
//{{{ getComponentParent() method
/**
	 * Finds a parent of the specified component.
	 * @param comp The component
	 * @param clazz Looks for a parent with this class (exact match, not
	 * derived).
	 * @since jEdit 4.2pre1
	 */
public static Component getComponentParent(Component comp, Class clazz) {
    while (true) {
        if (comp == null)
            break;
        if (comp instanceof JComponent) {
            Component real = (Component) ((JComponent) comp).getClientProperty("KORTE_REAL_FRAME");
            if (real != null)
                comp = real;
        }
        if (comp.getClass().equals(clazz))
            return comp;
        else if (comp instanceof JPopupMenu)
            comp = ((JPopupMenu) comp).getInvoker();
        else if (comp instanceof FloatingWindowContainer) {
            comp = ((FloatingWindowContainer) comp).getDockableWindowManager();
        } else
            comp = comp.getParent();
    }
    return null;
}