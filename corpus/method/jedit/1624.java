/**
        Resolve name to an object through this namespace.
    */
public Object get(String name, Interpreter interpreter) throws UtilEvalError {
    CallStack callstack = new CallStack(this);
    return getNameResolver(name).toObject(callstack, interpreter);
}