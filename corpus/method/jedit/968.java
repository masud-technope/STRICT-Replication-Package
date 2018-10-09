private Object arrayAllocation(BSHArrayDimensions dimensionsNode, Class type, CallStack callstack, Interpreter interpreter) throws EvalError {
    /*
			dimensionsNode can return either a fully intialized array or VOID.
			when VOID the prescribed array dimensions (defined and undefined)
			are contained in the node.
		*/
    Object result = dimensionsNode.eval(type, callstack, interpreter);
    if (result != Primitive.VOID)
        return result;
    else
        return arrayNewInstance(type, dimensionsNode, callstack);
}