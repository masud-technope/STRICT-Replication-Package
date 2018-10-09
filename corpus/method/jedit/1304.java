/**
		Set a new base classpath and create a new base classloader.
		This means all types change. 
	*/
public void setClassPath(URL[] cp) {
    baseClassPath.setPath(cp);
    initBaseLoader();
    loaderMap = new HashMap();
    classLoaderChanged();
}