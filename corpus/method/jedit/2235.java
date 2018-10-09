/*
    */
public static Object[] wrap(Object[] args, Class[] paramTypes) {
    if (args == null)
        return null;
    Object[] oa = new Object[args.length];
    for (int i = 0; i < args.length; i++) oa[i] = wrap(args[i], paramTypes[i]);
    return oa;
}