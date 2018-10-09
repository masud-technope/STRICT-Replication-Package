/**
		Evaluate the method invocation with the specified callstack and 
		interpreter
	*/
public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    NameSpace namespace = callstack.top();
    BSHAmbiguousName nameNode = getNameNode();
    // (i.e. inside a constructor)
    if (namespace.getParent() != null && namespace.getParent().isClass && (nameNode.text.equals("super") || nameNode.text.equals("this")))
        return Primitive.VOID;
    Name name = nameNode.getName(namespace);
    Object[] args = getArgsNode().getArguments(callstack, interpreter);
    // Move to Reflect?
    try {
        return name.invokeMethod(interpreter, args, callstack, this);
    } catch (ReflectError e) {
        throw new EvalError("Error in method invocation: " + e.getMessage(), this, callstack);
    } catch (InvocationTargetException e) {
        String msg = "Method Invocation " + name;
        Throwable te = e.getTargetException();
        boolean isNative = true;
        if (te instanceof EvalError)
            if (te instanceof TargetError)
                isNative = ((TargetError) te).inNativeCode();
            else
                isNative = false;
        throw new TargetError(msg, te, this, callstack, isNative);
    } catch (UtilEvalError e) {
        throw e.toEvalError(this, callstack);
    }
}