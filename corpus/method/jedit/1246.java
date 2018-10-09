/**
		@param topPath indicates that this is the top level classpath
		component and it should send the startClassMapping message
	*/
protected synchronized void insureInitialized(boolean topPath) {
    // inform the listeners we are going to do expensive map
    if (topPath && !mapsInitialized)
        startClassMapping();
    // initialize components
    if (compPaths != null)
        for (int i = 0; i < compPaths.size(); i++) ((BshClassPath) compPaths.get(i)).insureInitialized(false);
    // initialize ourself
    if (!mapsInitialized)
        map((URL[]) path.toArray(new URL[0]));
    if (topPath && !mapsInitialized)
        endClassMapping();
    mapsInitialized = true;
}