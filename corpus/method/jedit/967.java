private Object primitiveArrayAllocation(BSHPrimitiveType typeNode, BSHArrayDimensions dimensionsNode, CallStack callstack, Interpreter interpreter) throws EvalError {
    Class type = typeNode.getType();
    return arrayAllocation(dimensionsNode, type, callstack, interpreter);
}