//}}}
//{{{ loadMenuItem() method
/**
	 * Creates a menu item.
	 * @param context An action context; either
	 * <code>jEdit.getActionContext()</code> or
	 * <code>VFSBrowser.getActionContext()</code>.
	 * @param name The menu item name
	 * @param setMnemonic True if the menu item should have a mnemonic
	 * @return the menu item
	 * @since jEdit 4.2pre1
	 */
public static JMenuItem loadMenuItem(ActionContext context, String name, boolean setMnemonic) {
    if (name.charAt(0) == '%')
        return loadMenu(context, name.substring(1));
    return _loadMenuItem(name, context, setMnemonic);
}