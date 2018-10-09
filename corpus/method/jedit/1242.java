/**
		Explicitly set a class source.  This is used for generated classes, but
		could potentially be used to allow a user to override which version of
		a class from the classpath is located.
	*/
public synchronized void setClassSource(String className, ClassSource cs) {
    classSource.put(className, cs);
}