/**
		Reload all classes in the specified package: e.g. "com.sun.tools"

		The special package name "&lt;unpackaged&gt;" can be used to refer 
		to unpackaged classes.
	*/
public void reloadPackage(String pack) throws ClassPathException {
    Collection classes = baseClassPath.getClassesForPackage(pack);
    if (classes == null)
        classes = BshClassPath.getUserClassPath().getClassesForPackage(pack);
    if (classes == null)
        throw new ClassPathException("No classes found for package: " + pack);
    reloadClasses((String[]) classes.toArray(new String[0]));
}