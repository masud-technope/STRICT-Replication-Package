//}}}
//}}}
//{{{ Menus, tool bars
//{{{ loadMenuBar() method
/**
	 * Creates a menubar. Plugins should not need to call this method.
	 * @param name The menu bar name
	 * @return the menu bar
	 * @since jEdit 3.2pre5
	 */
public static JMenuBar loadMenuBar(String name) {
    return loadMenuBar(jEdit.getActionContext(), name);
}