/**
		Return the name or null if none is found,
		Throw an ClassPathException containing detail if name is ambigous.
	*/
public String getClassNameByUnqName(String name) throws ClassPathException {
    return getClassPath().getClassNameByUnqName(name);
}