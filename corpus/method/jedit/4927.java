//}}}
//{{{ getActionSetForAction() method
/**
	 * Returns the action set that contains the specified action.
	 *
	 * @param action The action
	 * @return the actionSet that contains the given action
	 * @since jEdit 4.3pre13
	 */
public E getActionSetForAction(String action) {
    return actionHash.get(action);
}