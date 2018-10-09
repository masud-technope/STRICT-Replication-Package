//}}}
//{{{ addKeyBinding() method
/**
	 * Adds a key binding to this input handler. The key binding is
	 * a list of white space separated key strokes of the form
	 * <i>[modifiers+]key</i> where modifier is C for Control, A for Alt,
	 * or S for Shift, and key is either a character (a-z) or a field
	 * name in the KeyEvent class prefixed with VK_ (e.g., BACK_SPACE)
	 * @param keyBinding The key binding
	 * @param action The action
	 * @since jEdit 4.2pre1
	 */
public void addKeyBinding(String keyBinding, String action) {
    addKeyBinding(keyBinding, (Object) action);
}