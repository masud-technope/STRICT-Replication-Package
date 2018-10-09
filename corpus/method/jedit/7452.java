//}}}
// {{{ closeAllMenus()
/** closes any popup menus that may have been opened
		@since jEdit 4.4pre1
	*/
public void closeAllMenus() {
    MenuSelectionManager.defaultManager().clearSelectedPath();
    KeyboardFocusManager.getCurrentKeyboardFocusManager().clearGlobalFocusOwner();
}