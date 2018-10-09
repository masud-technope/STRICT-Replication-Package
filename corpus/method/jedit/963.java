private Object constructObject(Class type, Object[] args, CallStack callstack) throws EvalError {
    Object obj;
    try {
        obj = Reflect.constructObject(type, args);
    } catch (ReflectError e) {
        throw new EvalError("Constructor error: " + e.getMessage(), this, callstack);
    } catch (InvocationTargetException e) {
        Interpreter.debug("The constructor threw an exception:\n\t" + e.getTargetException());
        throw new TargetError("Object constructor", e.getTargetException(), this, callstack, true);
    }
    String className = type.getName();
    // Is it an inner class?
    if (className.indexOf("$") == -1)
        return obj;
    // Temporary hack to support inner classes 
    // If the obj is a non-static inner class then import the context...
    // This is not a sufficient emulation of inner classes.
    // Replace this later...
    // work through to class 'this'
    This ths = callstack.top().getThis(null);
    NameSpace instanceNameSpace = Name.getClassNameSpace(ths.getNameSpace());
    // fake inner classes...  could generate a flag field.
    if (instanceNameSpace != null && className.startsWith(instanceNameSpace.getName() + "$")) {
        try {
            ClassGenerator.getClassGenerator().setInstanceNameSpaceParent(obj, className, instanceNameSpace);
        } catch (UtilEvalError e) {
            throw e.toEvalError(this, callstack);
        }
    }
    return obj;
}