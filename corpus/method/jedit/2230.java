/**
		Get the corresponding primitive TYPE class for the java.lang wrapper
		class type.
		e.g.  Integer.class -&gt; Integer.TYPE
	*/
public static Class unboxType(Class wrapperType) {
    Class c = (Class) wrapperMap.get(wrapperType);
    if (c != null)
        return c;
    throw new InterpreterError("Not a primitive wrapper type: " + wrapperType);
}