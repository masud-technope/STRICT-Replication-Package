//}}}
//{{{ getActionNames() method
/**
	 * @return all registered action names.
	 */
public String[] getActionNames() {
    if (actionNames == null) {
        List<String> vec = new LinkedList<String>();
        for (int i = 0; i < actionSets.size(); i++) (actionSets.elementAt(i)).getActionNames(vec);
        actionNames = vec.toArray(new String[vec.size()]);
        Arrays.sort(actionNames, new StandardUtilities.StringCompare<String>(true));
    }
    return Arrays.copyOf(actionNames, actionNames.length);
}