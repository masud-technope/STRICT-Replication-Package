//}}}
//{{{ removeAction() method
/**
	 * Removes an action from the action set.
	 * @param name The action name
	 * @since jEdit 4.0pre1
	 */
public void removeAction(String name) {
    actions.remove(name);
    if (context != null) {
        context.actionNames = null;
        context.actionHash.remove(name);
    }
}