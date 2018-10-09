/**
		Return the source of the specified class which may lie in component 
		path.
	*/
public synchronized ClassSource getClassSource(String className) {
    // Before triggering classpath mapping (initialization) check for
    // explicitly set class sources (e.g. generated classes).  These would
    // take priority over any found in the classpath anyway.
    ClassSource cs = (ClassSource) classSource.get(className);
    if (cs != null)
        return cs;
    // trigger possible mapping
    insureInitialized();
    cs = (ClassSource) classSource.get(className);
    if (cs == null && compPaths != null)
        for (int i = 0; i < compPaths.size() && cs == null; i++) cs = ((BshClassPath) compPaths.get(i)).getClassSource(className);
    return cs;
}