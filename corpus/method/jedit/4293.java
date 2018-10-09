//}}}
//{{{ loadMenu() method
/**
	 * Creates a menu. The menu label is set from the
	 * <code><i>name</i>.label</code> property. The menu contents is taken
	 * from the <code><i>name</i></code> property, which is a whitespace
	 * separated list of action names. An action name of <code>-</code>
	 * inserts a separator in the menu.
	 * @param context An action context; either
	 * <code>jEdit.getActionContext()</code> or
	 * <code>VFSBrowser.getActionContext()</code>.
	 * @param name The menu name
	 * @return a menu
	 * @see #loadMenuItem(String)
	 * @since jEdit 4.2pre1
	 */
public static JMenu loadMenu(ActionContext context, String name) {
    return new EnhancedMenu(name, jEdit.getProperty(name.concat(".label")), context);
}