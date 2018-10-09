//}}}
//{{{ createBeanShellAction() method
/**
	 * This method should be implemented to return an action that will execute
	 * the given code
	 * @param actionName the action name
	 * @param code the code
	 * @param selected selected
	 * @param noRepeat noRepeat
	 * @param noRecord noRecord
	 * @param noRememberLast noRememberLast
	 * @return an action
	 * @since 4.3pre13
	 */
protected abstract JEditAbstractEditAction createBeanShellAction(String actionName, String code, String selected, boolean noRepeat, boolean noRecord, boolean noRememberLast);