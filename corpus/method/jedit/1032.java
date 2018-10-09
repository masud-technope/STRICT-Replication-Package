// Move me to classpath/ClassManagerImpl???
protected Class loadSourceClass(String name) {
    String fileName = "/" + name.replace('.', '/') + ".java";
    InputStream in = getResourceAsStream(fileName);
    if (in == null)
        return null;
    try {
        System.out.println("Loading class from source file: " + fileName);
        declaringInterpreter.eval(new InputStreamReader(in));
    } catch (EvalError e) {
        System.err.println(e);
    }
    try {
        return plainClassForName(name);
    } catch (ClassNotFoundException e) {
        System.err.println("Class not found in source file: " + name);
        return null;
    }
}