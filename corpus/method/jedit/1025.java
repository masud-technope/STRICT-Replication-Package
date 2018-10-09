/**
        Set an external class loader.  BeanShell will use this at the same
        point it would otherwise use the plain Class.forName().
        i.e. if no explicit classpath management is done from the script
        (addClassPath(), setClassPath(), reloadClasses()) then BeanShell will
        only use the supplied classloader.  If additional classpath management
        is done then BeanShell will perform that in addition to the supplied
        external classloader.
        However BeanShell is not currently able to reload
        classes supplied through the external classloader.
    */
public void setClassLoader(ClassLoader externalCL) {
    externalClassLoader = externalCL;
    classLoaderChanged();
}