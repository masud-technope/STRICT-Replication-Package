//}}}
//{{{ loadPopupMenu() method
/**
	 * Creates a popup menu.
	 * @param context An action context; either
	 * <code>jEdit.getActionContext()</code> or
	 * <code>VFSBrowser.getActionContext()</code>.
	 * @param name The menu name
	 * @param textArea the textArea wanting to show the popup.
	 * 	If not null, include context menu items defined by services.
	 * @param evt additional context info about where the mouse was when menu was requested
	 * @return the popup menu
	 * @since jEdit 4.3pre15
	 */
public static JPopupMenu loadPopupMenu(ActionContext context, String name, JEditTextArea textArea, MouseEvent evt) {
    JPopupMenu menu = new JPopupMenu();
    String menuItems = jEdit.getProperty(name);
    if (menuItems != null) {
        StringTokenizer st = new StringTokenizer(menuItems);
        while (st.hasMoreTokens()) {
            String menuItemName = st.nextToken();
            if ("-".equals(menuItemName))
                menu.addSeparator();
            else
                menu.add(loadMenuItem(context, menuItemName, false));
        }
    }
    // load menu items defined by services
    if (textArea != null) {
        List<JMenuItem> list = GUIUtilities.getServiceContextMenuItems(textArea, evt);
        if (!list.isEmpty()) {
            menu.addSeparator();
        }
        for (JMenuItem mi : list) {
            menu.add(mi);
        }
    }
    return menu;
}