//}}}
//{{{ getActionSets() method
/**
	 * @return all registered action sets.
	 * @since jEdit 4.3pre13
	 */
@SuppressWarnings({ "unchecked" })
public E[] getActionSets() {
    if (actionSets.isEmpty())
        return null;
    Class clazz = actionSets.get(0).getClass();
    E[] retVal = (E[]) Array.newInstance(clazz, actionSets.size());
    actionSets.copyInto(retVal);
    return retVal;
}