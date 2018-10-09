public Class[] getParameterTypes() {
    // BSHFormalParameters will cache the type for us
    try {
        return (Class[]) paramTypesNode.eval(callstack, interpreter);
    } catch (EvalError e) {
        throw new InterpreterError("can't eval param types: " + e);
    }
}