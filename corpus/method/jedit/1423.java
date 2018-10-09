/**
		Set an external class loader to be used as the base classloader
		for BeanShell.  The base classloader is used for all classloading
		unless/until the addClasspath()/setClasspath()/reloadClasses()
		commands are called to modify the interpreter's classpath.  At that
		time the new paths /updated paths are added on top of the base
		classloader.
		<p>

		BeanShell will use this at the same point it would otherwise use the
		plain Class.forName().
		i.e. if no explicit classpath management is done from the script
		(addClassPath(), setClassPath(), reloadClasses()) then BeanShell will
		only use the supplied classloader.  If additional classpath management
		is done then BeanShell will perform that in addition to the supplied
		external classloader.
		However BeanShell is not currently able to reload
		classes supplied through the external classloader.
		<p>

		@see BshClassManager#setClassLoader( ClassLoader )
	*/
public void setClassLoader(ClassLoader externalCL) {
    getClassManager().setClassLoader(externalCL);
}