public Class getType(CallStack callstack, Interpreter interpreter) throws EvalError {
    // return cached type if available
    if (type != null)
        return type;
    //  first node will either be PrimitiveType or AmbiguousName
    SimpleNode node = getTypeNode();
    if (node instanceof BSHPrimitiveType)
        baseType = ((BSHPrimitiveType) node).getType();
    else
        baseType = ((BSHAmbiguousName) node).toClass(callstack, interpreter);
    if (arrayDims > 0) {
        try {
            // Get the type by constructing a prototype array with
            // arbitrary (zero) length in each dimension.
            // int array default zeros
            int[] dims = new int[arrayDims];
            Object obj = Array.newInstance(baseType, dims);
            type = obj.getClass();
        } catch (Exception e) {
            throw new EvalError("Couldn't construct array type", this, callstack);
        }
    } else
        type = baseType;
    // hack... sticking to first interpreter that resolves this
    // see comments on type instance variable
    interpreter.getClassManager().addListener(this);
    return type;
}