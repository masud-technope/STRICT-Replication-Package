/**
	*/
public String[] getVariableNames() {
    // union of the names in the internal namespace and external map
    Set nameSet = new HashSet();
    String[] nsNames = super.getVariableNames();
    nameSet.addAll(Arrays.asList(nsNames));
    nameSet.addAll(externalMap.keySet());
    return (String[]) nameSet.toArray(new String[0]);
}