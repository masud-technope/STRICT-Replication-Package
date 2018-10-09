//}}}
//{{{ loadPopupMenu() method
/**
	 * @return a popup menu.
	 * @param name The menu name
	 * @since jEdit 2.6pre2
	 */
public static JPopupMenu loadPopupMenu(String name) {
    return loadPopupMenu(jEdit.getActionContext(), name);
}