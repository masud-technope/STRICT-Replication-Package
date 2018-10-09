//}}}
//{{{ addAction() method
/**
	 * Adds an action to the action set.
	 * @param action The action
	 * @since jEdit 4.0pre1
	 */
@SuppressWarnings({ "unchecked" })
public void addAction(E action) {
    actions.put(action.getName(), action);
    if (context != null) {
        context.actionNames = null;
        context.actionHash.put(action.getName(), this);
    }
}