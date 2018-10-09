/**
		Clear all classloading behavior and class caches and reset to 
		initial state.
	*/
public void reset() {
    baseClassPath = new BshClassPath("baseClassPath");
    baseLoader = null;
    loaderMap = new HashMap();
    // calls clearCaches() for us.
    classLoaderChanged();
}