//{{{ getActionSetForAction() method
/**
	 * Returns the action set that contains the specified action.
	 * This method is still here for binary compatility
	 *
	 * @param action The action
	 * @return the actionSet that contains the given action
	 * @since jEdit 4.2pre1
	 */
@Override
public ActionSet getActionSetForAction(String action) {
    return super.getActionSetForAction(action);
}