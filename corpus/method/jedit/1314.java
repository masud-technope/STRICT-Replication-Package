/**
		init the baseLoader from the baseClassPath
	*/
private void initBaseLoader() {
    baseLoader = new BshClassLoader(this, baseClassPath);
}