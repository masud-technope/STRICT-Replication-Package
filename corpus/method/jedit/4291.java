//}}}
//{{{ loadMenuBar() method
/**
	 * Creates a menubar. Plugins should not need to call this method.
	 * @param context An action context
	 * @param name The menu bar name
	 * @return the menu bar
	 * @since jEdit 4.2pre1
	 */
public static JMenuBar loadMenuBar(ActionContext context, String name) {
    String menus = jEdit.getProperty(name);
    StringTokenizer st = new StringTokenizer(menus);
    JMenuBar mbar = new JMenuBar();
    while (st.hasMoreTokens()) {
        String menuName = st.nextToken();
        mbar.add(loadMenu(context, menuName));
    }
    return mbar;
}