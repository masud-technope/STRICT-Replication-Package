//}}}
//{{{ loadMenu() method
/**
	 * Creates a menu. The menu label is set from the
	 * <code><i>name</i>.label</code> property. The menu contents is taken
	 * from the <code><i>name</i></code> property, which is a whitespace
	 * separated list of action names. An action name of <code>-</code>
	 * inserts a separator in the menu.
	 * @param name The menu name
	 * @return a menu
	 * @see #loadMenuItem(String)
	 * @since jEdit 2.6pre2
	 */
public static JMenu loadMenu(String name) {
    return loadMenu(jEdit.getActionContext(), name);
}