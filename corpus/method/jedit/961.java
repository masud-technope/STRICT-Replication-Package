public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    // type is either a class name or a primitive type
    SimpleNode type = (SimpleNode) jjtGetChild(0);
    // args is either constructor arguments or array dimensions
    SimpleNode args = (SimpleNode) jjtGetChild(1);
    if (type instanceof BSHAmbiguousName) {
        BSHAmbiguousName name = (BSHAmbiguousName) type;
        if (args instanceof BSHArguments)
            return objectAllocation(name, (BSHArguments) args, callstack, interpreter);
        else
            return objectArrayAllocation(name, (BSHArrayDimensions) args, callstack, interpreter);
    } else
        return primitiveArrayAllocation((BSHPrimitiveType) type, (BSHArrayDimensions) args, callstack, interpreter);
}