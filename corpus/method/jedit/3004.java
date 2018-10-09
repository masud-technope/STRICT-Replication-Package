//}}}
//{{{ createMenuItems() method
/**
	 * Called by the view when constructing its <b>Plugins</b> menu.
	 * See the description of this class for details about how the
	 * menu items are constructed from plugin properties.
	 * @return the menu item
	 * @since jEdit 4.2pre1
	 */
public final JMenuItem createMenuItems() {
    if (this instanceof Broken)
        return null;
    String menuItemName = jEdit.getProperty("plugin." + getClassName() + ".menu-item");
    if (menuItemName != null)
        return GUIUtilities.loadMenuItem(menuItemName);
    String menuProperty = "plugin." + getClassName() + ".menu";
    String codeProperty = "plugin." + getClassName() + ".menu.code";
    if (jEdit.getProperty(menuProperty) != null || jEdit.getProperty(codeProperty) != null) {
        String pluginName = jEdit.getProperty("plugin." + getClassName() + ".name");
        return new EnhancedMenu(menuProperty, pluginName);
    }
    return null;
}