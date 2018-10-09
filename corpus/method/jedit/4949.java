//}}}
//{{{ getActions() method
/**
	 * @return an array of all actions in this action set.<p>
	 *
	 * <b>Deferred loading:</b> this will load the action set if necessary.
	 *
	 * @since jEdit 4.0pre1
	 */
@SuppressWarnings({ "unchecked" })
public E[] getActions() {
    load();
    E[] retVal = getArray(actions.size());
    Collection<JEditAbstractEditAction> values = actions.values();
    int i = 0;
    for (JEditAbstractEditAction value : values) {
        retVal[i++] = (E) value;
    }
    return retVal;
}