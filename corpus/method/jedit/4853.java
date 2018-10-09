//}}}
//{{{ removeActionSet() method
/**
	 * Removes an action set from jEdit's list.
	 * Plugins that add a dynamic action set must call this method at plugin
	 * unload time.
	 * @since jEdit 4.2pre1
	 */
public static void removeActionSet(ActionSet actionSet) {
    actionContext.removeActionSet(actionSet);
}