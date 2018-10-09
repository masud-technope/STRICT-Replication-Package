//}}}
//{{{ loadClass() method
/**
	 * @exception ClassNotFoundException if the class could not be found
	 */
public Class loadClass(String clazz, boolean resolveIt) throws ClassNotFoundException {
    ClassNotFoundException pending = null;
    if (delegateFirst) {
        try {
            return loadFromParent(clazz);
        } catch (ClassNotFoundException cnf) {
            pending = cnf;
        }
    }
    Object obj = classHash.get(clazz);
    if (obj == NO_CLASS) {
        // <imported prefix>.<class name> combinations
        throw new ClassNotFoundException(clazz);
    } else if (obj instanceof JARClassLoader) {
        JARClassLoader classLoader = (JARClassLoader) obj;
        try {
            return classLoader._loadClass(clazz, resolveIt);
        } catch (ClassNotFoundException cnf2) {
            classHash.put(clazz, NO_CLASS);
            throw cnf2;
        }
    } else if (delegateFirst) {
        // we'll try loading from the parent class loader.
        throw pending;
    }
    return loadFromParent(clazz);
}