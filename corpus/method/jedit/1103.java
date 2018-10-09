/*
		Field access, .length on array, or a method invocation
		Must handle toLHS case for each.
	*/
private Object doName(Object obj, boolean toLHS, CallStack callstack, Interpreter interpreter) throws EvalError, ReflectError, InvocationTargetException {
    try {
        // .length on array
        if (field.equals("length") && obj.getClass().isArray())
            if (toLHS)
                throw new EvalError("Can't assign array length", this, callstack);
            else
                return new Primitive(Array.getLength(obj));
        // field access
        if (jjtGetNumChildren() == 0)
            if (toLHS)
                return Reflect.getLHSObjectField(obj, field);
            else
                return Reflect.getObjectFieldValue(obj, field);
        // Method invocation
        // (LHS or non LHS evaluation can both encounter method calls)
        Object[] oa = ((BSHArguments) jjtGetChild(0)).getArguments(callstack, interpreter);
        // maybe move this to Reflect ?
        try {
            return Reflect.invokeObjectMethod(obj, field, oa, interpreter, callstack, this);
        } catch (ReflectError e) {
            throw new EvalError("Error in method invocation: " + e.getMessage(), this, callstack);
        } catch (InvocationTargetException e) {
            String msg = "Method Invocation " + field;
            Throwable te = e.getTargetException();
            boolean isNative = true;
            if (te instanceof EvalError)
                if (te instanceof TargetError)
                    isNative = ((TargetError) te).inNativeCode();
                else
                    isNative = false;
            throw new TargetError(msg, te, this, callstack, isNative);
        }
    } catch (UtilEvalError e) {
        throw e.toEvalError(this, callstack);
    }
}