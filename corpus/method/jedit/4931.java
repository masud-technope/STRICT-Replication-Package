//}}}
//{{{ removeActionSet() method
/**
	 * @param actionSet Removes an action set from the context.
	 * @since jEdit 4.23pre13
	 */
public void removeActionSet(E actionSet) {
    actionNames = null;
    actionSets.removeElement(actionSet);
    actionSet.context = null;
    String[] actions = actionSet.getActionNames();
    for (String action : actions) {
        actionHash.remove(action);
        if (overriddenActions.containsKey(action)) {
            E oldAction = overriddenActions.remove(action);
            actionHash.put(action, oldAction);
        }
    }
}