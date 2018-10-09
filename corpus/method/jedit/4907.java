//}}}
//{{{ initKeyBindings() method
/**
	 * Loads all key bindings from the properties.
	 *
	 * @since 3.1pre1
	 */
private static void initKeyBindings() {
    inputHandler.removeAllKeyBindings();
    ActionSet[] actionSets = getActionSets();
    for (ActionSet actionSet : actionSets) actionSet.initKeyBindings();
}