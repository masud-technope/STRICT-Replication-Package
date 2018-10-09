//}}}
//{{{ getActionNames() method
/**
	 * @return an array of all action names in this action set.
	 * @since jEdit 4.2pre1
	 */
public String[] getActionNames() {
    String[] retVal = new String[actions.size()];
    Set<String> keys = actions.keySet();
    int i = 0;
    for (String key : keys) {
        retVal[i++] = key;
    }
    return retVal;
}