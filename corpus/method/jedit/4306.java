//}}}
//{{{ loadMenuItem() method
/**
	 * Creates a menu item. The menu item is bound to the action named by
	 * <code>name</code> with label taken from the return value of the
	 * {@link EditAction#getLabel()} method.
	 *
	 * @param name The menu item name
	 * @return the menu item
	 * @see #loadMenu(String)
	 * @since jEdit 2.6pre1
	 */
public static JMenuItem loadMenuItem(String name) {
    return loadMenuItem(jEdit.getActionContext(), name, true);
}