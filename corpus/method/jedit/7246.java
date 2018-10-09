//}}}
//{{{ addActionSet() method
/**
	 * Adds a new action set to the textarea's list of ActionSets.
	 * Call this only on standalone textarea
	 *
	 * @param actionSet the actionSet to add
	 * @since jEdit 4.3pre13
	 */
public void addActionSet(JEditActionSet<JEditBeanShellAction> actionSet) {
    actionContext.addActionSet(actionSet);
}