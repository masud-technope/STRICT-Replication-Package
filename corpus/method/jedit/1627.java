/**
        This method simply delegates to This.invokeMethod();
        <p>
        @see org.gjt.sp.jedit.bsh.This#invokeMethod(String methodName, Object [] args, Interpreter interpreter, CallStack callstack, SimpleNode callerInfo, boolean declaredOnly ) invokeMethod
    */
public Object invokeMethod(String methodName, Object[] args, Interpreter interpreter, CallStack callstack, SimpleNode callerInfo) throws EvalError {
    return getThis(interpreter).invokeMethod(methodName, args, interpreter, callstack, callerInfo, false);
}