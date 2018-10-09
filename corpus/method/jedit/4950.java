//}}}
//{{{ contains() method
/**
	 * @return if this action set contains the specified action.
	 * @param action The action
	 * @since jEdit 4.2pre1
	 */
public boolean contains(String action) {
    boolean retval = actions.containsKey(action);
    return retval;
//		return actions.containsKey(action);
}