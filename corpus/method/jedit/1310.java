/**
		Support for "import *;"
		Hide details in here as opposed to NameSpace.
	*/
public void doSuperImport() throws UtilEvalError {
    try {
        getClassPath().insureInitialized();
        // prime the lookup table
        getClassNameByUnqName("");
    // always true now
    //getClassPath().setNameCompletionIncludeUnqNames(true);
    } catch (ClassPathException e) {
        throw new UtilEvalError("Error importing classpath " + e);
    }
    superImport = true;
}