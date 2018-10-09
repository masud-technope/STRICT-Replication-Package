/**
		Get the full path including component paths.
		(component paths listed first, in order)
		Duplicate path components are removed.
	*/
protected List getFullPath() {
    List list = new ArrayList();
    if (compPaths != null) {
        for (int i = 0; i < compPaths.size(); i++) {
            List l = ((BshClassPath) compPaths.get(i)).getFullPath();
            // take care to remove dups
            // wish we had an ordered set collection
            Iterator it = l.iterator();
            while (it.hasNext()) {
                Object o = it.next();
                if (!list.contains(o))
                    list.add(o);
            }
        }
    }
    list.addAll(path);
    return list;
}