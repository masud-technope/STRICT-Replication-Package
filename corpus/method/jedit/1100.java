/**
		Property access.
		Must handle toLHS case.
	*/
private Object doProperty(boolean toLHS, Object obj, CallStack callstack, Interpreter interpreter) throws EvalError {
    if (obj == Primitive.VOID)
        throw new EvalError("Attempt to access property on undefined variable or class name", this, callstack);
    if (obj instanceof Primitive)
        throw new EvalError("Attempt to access property on a primitive", this, callstack);
    Object value = ((SimpleNode) jjtGetChild(0)).eval(callstack, interpreter);
    if (!(value instanceof String))
        throw new EvalError("Property expression must be a String or identifier.", this, callstack);
    if (toLHS)
        return new LHS(obj, (String) value);
    // Property style access to Hashtable or Map
    CollectionManager cm = CollectionManager.getCollectionManager();
    if (cm.isMap(obj)) {
        Object val = cm.getFromMap(/*key*/
        obj, value);
        return (val == null ? val = Primitive.NULL : val);
    }
    try {
        return Reflect.getObjectProperty(obj, (String) value);
    } catch (UtilEvalError e) {
        throw e.toEvalError("Property: " + value, this, callstack);
    } catch (ReflectError e) {
        throw new EvalError("No such property: " + value, this, callstack);
    }
}