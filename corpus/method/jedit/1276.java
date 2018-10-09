/**
		Get a list of all of the known packages
	*/
public Set getPackagesSet() {
    insureInitialized();
    Set set = new HashSet();
    set.addAll(packageMap.keySet());
    if (compPaths != null)
        for (int i = 0; i < compPaths.size(); i++) set.addAll(((BshClassPath) compPaths.get(i)).packageMap.keySet());
    return set;
}