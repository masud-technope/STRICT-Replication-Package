//}}}
//{{{ addActionSet() method
/**
	 * Adds a new action set to jEdit's list of ActionSets (viewable from the shortcuts
	 * option pane). By default, each plugin has one ActionSet,
	 * but some plugins may create dynamic action sets, such as ProjectViewer and Console.
	 * These plugins must call removeActionSet() when the plugin is unloaded.
	 *
	 * @since jEdit 4.0pre1
	 * @see #removeActionSet(ActionSet)
	 */
public static void addActionSet(ActionSet actionSet) {
    actionContext.addActionSet(actionSet);
}