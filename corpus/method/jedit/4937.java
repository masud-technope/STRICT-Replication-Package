//}}}
//{{{ initKeyBindings() method
/**
	 * Initializes the action set's key bindings.
	 * jEdit calls this method for all registered action sets when the
	 * user changes key bindings in the <b>Global Options</b> dialog box.<p>
	 *
	 * Note if your plugin adds a custom action set to jEdit's collection,
	 * it must also call this method on the action set after adding it.
	 *
	 * @since jEdit 4.2pre1
	 */
public void initKeyBindings() {
    AbstractInputHandler inputHandler = getInputHandler();
    Set<Map.Entry<String, JEditAbstractEditAction>> entries = actions.entrySet();
    for (Map.Entry<String, JEditAbstractEditAction> entry : entries) {
        String name = entry.getKey();
        String shortcut1 = getProperty(name + ".shortcut");
        if (shortcut1 != null)
            inputHandler.addKeyBinding(shortcut1, name);
        String shortcut2 = getProperty(name + ".shortcut2");
        if (shortcut2 != null)
            inputHandler.addKeyBinding(shortcut2, name);
    }
}