//}}}
// {{{ getActionSets() method
/**
	 * Returns all registered action sets.
	 *
	 * @return the ActionSet(s)
	 * @since jEdit 4.0pre1
	 */
public static ActionSet[] getActionSets() {
    return actionContext.getActionSets();
}