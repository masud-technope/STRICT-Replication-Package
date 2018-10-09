//}}}
//{{{ getCacheableActionNames() method
/**
	 * @return an array of all action names in this action set that should
	 * be cached; namely, <code>BeanShellAction</code>s.
	 * @since jEdit 4.2pre1
	 */
public String[] getCacheableActionNames() {
    LinkedList<String> retVal = new LinkedList<String>();
    for (Object obj : actions.values()) {
        if (obj == placeholder) {
            // ??? this should only be called with
            // fully loaded action set
            Log.log(Log.WARNING, this, "Action set not up " + "to date");
        } else if (obj instanceof JEditBeanShellAction)
            retVal.add(((JEditBeanShellAction) obj).getName());
    }
    return retVal.toArray(new String[retVal.size()]);
}