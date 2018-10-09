/**
	*/
public Class findClass(String name) throws ClassNotFoundException {
    // Load it if it's one of our classes
    ClassSource source = map.get(name);
    if (source != null) {
        byte[] code = source.getCode(name);
        return defineClass(name, code, 0, code.length);
    } else
        // to find the class...
        return super.findClass(name);
}