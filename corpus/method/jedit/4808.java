//}}}
//{{{ getActionSetForAction() method
/**
	 * Returns the action set that contains the specified action.
	 *
	 * @param action The action
	 * @since jEdit 4.2pre1
	 */
public static ActionSet getActionSetForAction(String action) {
    return actionContext.getActionSetForAction(action);
}