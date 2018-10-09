/**
		Get the BeanShell classloader.
	public ClassLoader getClassLoader() {
	}
	*/
/*
		Impl Notes:
		We add the bytecode source and the "reload" the class, which causes the
		BshClassLoader to be initialized and create a DiscreteFilesClassLoader
		for the bytecode.

		@exception ClassPathException can be thrown by reloadClasses
	*/
public Class defineClass(String name, byte[] code) {
    baseClassPath.setClassSource(name, new GeneratedClassSource(code));
    try {
        reloadClasses(new String[] { name });
    } catch (ClassPathException e) {
        throw new org.gjt.sp.jedit.bsh.InterpreterError("defineClass: " + e);
    }
    return classForName(name);
}