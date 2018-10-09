//}}}
//{{{ addActionSet() method
/**
	 * @param actionSet Adds a new action set to the context.
	 * @since jEdit 4.3pre13
	 */
public void addActionSet(E actionSet) {
    actionNames = null;
    actionSets.addElement(actionSet);
    actionSet.context = this;
    String[] actions = actionSet.getActionNames();
    for (String action : actions) {
        /* Is it already there? */
        if (actionHash.containsKey(action)) {
            /* Save it for plugin unloading time */
            E oldAction = actionHash.get(action);
            overriddenActions.put(action, oldAction);
        }
        actionHash.put(action, actionSet);
    }
}