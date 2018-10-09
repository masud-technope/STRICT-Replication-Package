/**
		Return the set of class names in the specified package
		including all component paths.
	*/
public synchronized Set getClassesForPackage(String pack) {
    insureInitialized();
    Set set = new HashSet();
    Collection c = (Collection) packageMap.get(pack);
    if (c != null)
        set.addAll(c);
    if (compPaths != null)
        for (int i = 0; i < compPaths.size(); i++) {
            c = ((BshClassPath) compPaths.get(i)).getClassesForPackage(pack);
            if (c != null)
                set.addAll(c);
        }
    return set;
}