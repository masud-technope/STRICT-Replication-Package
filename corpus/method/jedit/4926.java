//}}}
//{{{ getAction() method
/**
	 * Returns the specified action.
	 * @param name The action name
	 * @return a JEditAbstractEditAction or null if it doesn't exist
	 * @since jEdit 4.3pre13
	 */
public F getAction(String name) {
    E set = actionHash.get(name);
    if (set == null)
        return null;
    else
        return set.getAction(name);
}