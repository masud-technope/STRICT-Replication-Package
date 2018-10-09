/**
		Support for super import "*";
		Get the full name associated with the unqualified name in this 
		classpath.  Returns either the String name or an AmbiguousName object
		encapsulating the various names.
	*/
public String getClassNameByUnqName(String name) throws ClassPathException {
    insureInitialized();
    UnqualifiedNameTable unqNameTable = getUnqualifiedNameTable();
    Object obj = unqNameTable.get(name);
    if (obj instanceof AmbiguousName)
        throw new ClassPathException("Ambigous class names: " + ((AmbiguousName) obj).get());
    return (String) obj;
}