/*
        Unwrap Primitive wrappers to their java.lang wrapper values.
		e.g. Primitive(42) becomes Integer(42)
		@see #unwrap( Object )
    */
public static Object[] unwrap(Object[] args) {
    Object[] oa = new Object[args.length];
    for (int i = 0; i < args.length; i++) oa[i] = unwrap(args[i]);
    return oa;
}