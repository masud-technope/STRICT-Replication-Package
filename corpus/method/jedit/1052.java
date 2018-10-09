/**
		Evaluate the types.  
		Note that type resolution does not require the interpreter instance.
	*/
public Object eval(CallStack callstack, Interpreter interpreter) throws EvalError {
    if (paramTypes != null)
        return paramTypes;
    insureParsed();
    Class[] paramTypes = new Class[numArgs];
    for (int i = 0; i < numArgs; i++) {
        BSHFormalParameter param = (BSHFormalParameter) jjtGetChild(i);
        paramTypes[i] = (Class) param.eval(callstack, interpreter);
    }
    this.paramTypes = paramTypes;
    return paramTypes;
}