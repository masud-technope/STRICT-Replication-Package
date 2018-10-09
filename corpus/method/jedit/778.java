//}}}
//{{{ createPluginsMenu() method
public JComponent createPluginsMenu(JComponent pluginMenu, boolean showManagerOptions) {
    if (showManagerOptions && getMode() == BROWSER) {
        pluginMenu.add(GUIUtilities.loadMenuItem("plugin-manager", false));
        pluginMenu.add(GUIUtilities.loadMenuItem("plugin-options", false));
        if (pluginMenu instanceof JMenu)
            ((JMenu) pluginMenu).addSeparator();
        else if (pluginMenu instanceof JPopupMenu)
            ((JPopupMenu) pluginMenu).addSeparator();
    }
    /* else we're in a modal dialog */
    List<JMenuItem> vec = new ArrayList<JMenuItem>();
    //{{{ new API
    EditPlugin[] plugins = jEdit.getPlugins();
    for (EditPlugin plugin : plugins) {
        JMenuItem menuItem = plugin.createBrowserMenuItems();
        if (menuItem != null)
            vec.add(menuItem);
    //}}}
    }
    if (!vec.isEmpty()) {
        Collections.sort(vec, new MenuItemTextComparator());
        for (JMenuItem item : vec) pluginMenu.add(item);
    } else {
        JMenuItem mi = new JMenuItem(jEdit.getProperty("vfs.browser.plugins.no-plugins.label"));
        mi.setEnabled(false);
        pluginMenu.add(mi);
    }
    return pluginMenu;
}