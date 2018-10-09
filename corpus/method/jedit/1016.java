/**
        This has been removed from the interface to shield the core from the
        rest of the classpath package. If you need the classpath you will have
        to cast the classmanager to its impl.

        public BshClassPath getClassPath() throws ClassPathException;
    */
/**
        Support for "import *;"
        Hide details in here as opposed to NameSpace.
    */
protected void doSuperImport() throws UtilEvalError {
    throw cmUnavailable();
}