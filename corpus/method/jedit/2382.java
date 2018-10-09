/**
		Get the Java types of the arguments.
	*/
public static Class[] getTypes(Object[] args) {
    if (args == null)
        return new Class[0];
    Class[] types = new Class[args.length];
    for (int i = 0; i < args.length; i++) {
        if (args[i] == null)
            types[i] = null;
        else if (args[i] instanceof Primitive)
            types[i] = ((Primitive) args[i]).getType();
        else
            types[i] = args[i].getClass();
    }
    return types;
}