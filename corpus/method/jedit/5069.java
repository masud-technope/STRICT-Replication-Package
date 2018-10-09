//}}}
//{{{ createMacrosMenu() method
private void createMacrosMenu(JMenu menu, Vector vector, int start) {
    Vector<JMenuItem> menuItems = new Vector<JMenuItem>();
    int maxItems = jEdit.getIntegerProperty("menu.spillover", 20);
    JMenu subMenu = null;
    for (int i = start; i < vector.size(); i++) {
        if (i != start && i % maxItems == 0) {
            subMenu = new JMenu(jEdit.getProperty("common.more"));
            createMacrosMenu(subMenu, vector, i);
            break;
        }
        Object obj = vector.elementAt(i);
        if (obj instanceof String) {
            menuItems.add(new EnhancedMenuItem(jEdit.getProperty(obj + ".label"), (String) obj, jEdit.getActionContext()));
        } else if (obj instanceof Vector) {
            Vector subvector = (Vector) obj;
            String name = (String) subvector.elementAt(0);
            JMenu submenu = new JMenu(jEdit.getProperty("macros.folder." + name + ".label", name));
            createMacrosMenu(submenu, subvector, 1);
            if (submenu.getMenuComponentCount() != 0)
                menuItems.add(submenu);
        }
    }
    Collections.sort(menuItems, new MenuItemTextComparator());
    if (subMenu != null)
        menuItems.add(subMenu);
    for (JMenuItem menuItem : menuItems) menu.add(menuItem);
}