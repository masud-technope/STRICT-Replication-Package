//}}}
//{{{ createBrowserMenuItems() method
/**
	 * Called by the filesystem browser when constructing its
	 * <b>Plugins</b> menu.
	 * See the description of this class for details about how the
	 * menu items are constructed from plugin properties.
	 * @return the menu item
	 *
	 * @since jEdit 4.2pre1
	 */
public final JMenuItem createBrowserMenuItems() {
    if (this instanceof Broken)
        return null;
    String menuItemName = jEdit.getProperty("plugin." + getClassName() + ".browser-menu-item");
    if (menuItemName != null) {
        return GUIUtilities.loadMenuItem(VFSBrowser.getActionContext(), menuItemName, false);
    }
    String menuProperty = "plugin." + getClassName() + ".browser-menu";
    String codeProperty = "plugin." + getClassName() + ".browser-menu.code";
    if (jEdit.getProperty(menuProperty) != null || jEdit.getProperty(codeProperty) != null) {
        String pluginName = jEdit.getProperty("plugin." + getClassName() + ".name");
        return new EnhancedMenu(menuProperty, pluginName, VFSBrowser.getActionContext());
    }
    return null;
}