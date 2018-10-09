/**
        Get a version of this scripted object implementing the specified
        interfaces.
    */
public Object getInterface(Class[] ca) throws UtilEvalError {
    for (int i = 0; i < ca.length; i++) if (!(ca[i].isInstance(this)))
        throw new UtilEvalError("Dynamic proxy mechanism not available. " + "Cannot construct interface type: " + ca[i]);
    return this;
}