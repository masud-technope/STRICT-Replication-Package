//}}}
//{{{ loadPopupMenu() method
/**
	 * Creates a popup menu.

	 * @param context An action context; either
	 * <code>jEdit.getActionContext()</code> or
	 * <code>VFSBrowser.getActionContext()</code>.
	 * @param name The menu name
	 * @return a popup menu
	 * @since jEdit 4.2pre1
	 */
public static JPopupMenu loadPopupMenu(ActionContext context, String name) {
    return loadPopupMenu(context, name, null, null);
}