//}}}
//{{{ removeAllActions() method
/**
	 * Removes all actions from the action set.
	 * @since jEdit 4.0pre1
	 */
public void removeAllActions() {
    if (context != null) {
        context.actionNames = null;
        String[] actions = getActionNames();
        for (String action : actions) context.actionHash.remove(action);
    }
    actions.clear();
}