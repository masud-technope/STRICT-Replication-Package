/**
        Get dynamic proxy for interface, caching those it creates.
    */
public Object getInterface(Class[] ca) {
    if (interfaces == null)
        interfaces = new Hashtable();
    // Make a hash of the interface hashcodes in order to cache them
    int hash = 21;
    for (int i = 0; i < ca.length; i++) hash *= ca[i].hashCode() + 3;
    Object hashKey = Integer.valueOf(hash);
    Object interf = interfaces.get(hashKey);
    if (interf == null) {
        // ?
        ClassLoader classLoader = ca[0].getClassLoader();
        interf = Proxy.newProxyInstance(classLoader, ca, invocationHandler);
        interfaces.put(hashKey, interf);
    }
    return interf;
}