// }}}
//{{{ getAction() method
/**
	 * Returns the specified action.
	 * @param name The action name
	 */
public static EditAction getAction(String name) {
    return actionContext.getAction(name);
}