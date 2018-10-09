/**
        Get a version of this scripted object implementing the specified
        interface.
    */
/*
        If this type of This implements it directly return this,
        else try complain that we don't have the proxy mechanism.
    */
public Object getInterface(Class clas) throws UtilEvalError {
    if (clas.isInstance(this))
        return this;
    else
        throw new UtilEvalError("Dynamic proxy mechanism not available. " + "Cannot construct interface type: " + clas);
}