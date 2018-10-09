//}}}
//{{{ loadMenuItem() method
/**
	 * Creates a menu item.
	 * @param name The menu item name
	 * @param setMnemonic True if the menu item should have a mnemonic
	 * @return a menu item
	 * @since jEdit 3.1pre1
	 */
public static JMenuItem loadMenuItem(String name, boolean setMnemonic) {
    return loadMenuItem(jEdit.getActionContext(), name, setMnemonic);
}