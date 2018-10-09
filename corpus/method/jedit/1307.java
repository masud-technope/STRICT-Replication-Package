/**
		Overlay the entire path with a new class loader.
		Set the base path to the user path + base path.

		No point in including the boot class path (can't reload thos).
	*/
public void reloadAllClasses() throws ClassPathException {
    BshClassPath bcp = new BshClassPath("temp");
    bcp.addComponent(baseClassPath);
    bcp.addComponent(BshClassPath.getUserClassPath());
    setClassPath(bcp.getPathComponents());
}