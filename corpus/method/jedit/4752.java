//}}}
//{{{ loadFromParent() method
private Class loadFromParent(String clazz) throws ClassNotFoundException {
    Class cls;
    ClassLoader parentLoader = getClass().getClassLoader();
    if (parentLoader != null)
        cls = parentLoader.loadClass(clazz);
    else
        cls = findSystemClass(clazz);
    return cls;
}