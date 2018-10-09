/**
        Get dynamic proxy for interface, caching those it creates.
    */
public Object getInterface(Class clas) {
    return getInterface(new Class[] { clas });
}