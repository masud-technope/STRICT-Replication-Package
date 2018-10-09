//}}}
//{{{ createBeanShellAction() method
/**
	 * Creates a BeanShellAction.
	 * @since 4.3pre13
	 */
protected EditAction createBeanShellAction(String actionName, String code, String selected, boolean noRepeat, boolean noRecord, boolean noRememberLast) {
    return new BeanShellAction(actionName, code, selected, noRepeat, noRecord, noRememberLast);
}