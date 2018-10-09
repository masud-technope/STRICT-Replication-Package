/**
		Unimplemented
		For this we'd have to store a map by location as well as name...

	public void reloadPathComponent( URL pc ) throws ClassPathException {
		throw new ClassPathException("Unimplemented!");
	}
	*/
// end reloading
/**
		Get the full blown classpath.
	*/
public BshClassPath getClassPath() throws ClassPathException {
    if (fullClassPath != null)
        return fullClassPath;
    fullClassPath = new BshClassPath("BeanShell Full Class Path");
    fullClassPath.addComponent(BshClassPath.getUserClassPath());
    try {
        fullClassPath.addComponent(BshClassPath.getBootClassPath());
    } catch (ClassPathException e) {
        System.err.println("Warning: can't get boot class path");
    }
    fullClassPath.addComponent(baseClassPath);
    return fullClassPath;
}