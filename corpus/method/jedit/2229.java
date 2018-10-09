/**
		Get the corresponding java.lang wrapper class for the primitive TYPE
		class.
		e.g.  Integer.TYPE -&gt; Integer.class
	*/
public static Class boxType(Class primitiveType) {
    Class c = (Class) wrapperMap.get(primitiveType);
    if (c != null)
        return c;
    throw new InterpreterError("Not a primitive type: " + primitiveType);
}