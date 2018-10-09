private Object objectArrayAllocation(BSHAmbiguousName nameNode, BSHArrayDimensions dimensionsNode, CallStack callstack, Interpreter interpreter) throws EvalError {
    NameSpace namespace = callstack.top();
    Class type = nameNode.toClass(callstack, interpreter);
    if (type == null)
        throw new EvalError("Class " + nameNode.getName(namespace) + " not found.", this, callstack);
    return arrayAllocation(dimensionsNode, type, callstack, interpreter);
}